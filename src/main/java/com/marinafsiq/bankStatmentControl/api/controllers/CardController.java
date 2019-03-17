package com.marinafsiq.bankStatmentControl.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marinafsiq.bankStatmentControl.api.dtos.CardDto;
import com.marinafsiq.bankStatmentControl.api.entitiess.Card;
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.response.Response;
import com.marinafsiq.bankStatmentControl.api.services.CardService;
import com.marinafsiq.bankStatmentControl.api.services.PersonService;

@RestController
@RequestMapping("/api/card")
@CrossOrigin(origins="*")
public class CardController {
	
	private static Logger log = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<Response<CardDto>> addCard(@Valid @RequestBody CardDto cardDto
			, BindingResult results) throws NoSuchAlgorithmException{
		log.info("Adding card {}-{}", cardDto.getNickname(), cardDto.getNumber());
		
		Response<CardDto> response = new Response<CardDto>();
		
		//check if the card already exists and if the person exists
		checkIfCardAndPersonExists(cardDto, results);
		
		//return se tiver algum erro
		if(results.hasErrors()) {
			log.error("Error validating Card: {}", results.getAllErrors());
			results.getAllErrors().forEach(error -> response.addErrors(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		//persist in the database
		Card card = convertCardDtoIntoCard(cardDto);
		Person person = personService.findById(cardDto.getPersonId()).get();
		card.setPerson(person);
		ArrayList<Card> cardsList = new ArrayList<Card>(person.getCards());
		cardsList.add(card);
		person.setCards(cardsList);
		
		cardService.persist(card);
		personService.persist(person);
		
		cardDto.setId(Optional.of(card.getId()));
		response.setData(cardDto);
		
		return ResponseEntity.ok(response);
	} 
	
	private void checkIfCardAndPersonExists(CardDto cardDto, BindingResult result){
		cardService.findByNickname(cardDto.getNickname()).ifPresent(card -> result.addError(new ObjectError("Card", "There is alrady a card with nickname = "+card.getNickname()) ));
		cardService.findByNumber(cardDto.getNumber()).ifPresent(card -> result.addError(new ObjectError("Card", "There is already a card with number="+cardDto.getNumber())));
		Optional<Person> person = personService.findById(cardDto.getPersonId());
		if(!person.isPresent())
			result.addError(new ObjectError("Card", "The user with id="+ cardDto.getId() +" does not exists"));
	}
	
	private Card convertCardDtoIntoCard(CardDto dto) {
		Card card = new Card();
		
		card.setNickname(dto.getNickname());
		card.setNumber(dto.getNumber());
		card.setExpireDate(dto.getExpireDate());
		dto.getId().ifPresent(id -> card.setId(id));
		dto.getPurchases().ifPresent(purchases -> card.setPurchases(purchases));
		
		return card;
	}

}
