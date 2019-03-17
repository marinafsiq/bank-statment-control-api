package com.marinafsiq.bankStatmentControl.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marinafsiq.bankStatmentControl.api.dtos.UserDto;
import com.marinafsiq.bankStatmentControl.api.entitiess.Account;
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.response.Response;
import com.marinafsiq.bankStatmentControl.api.services.PersonService;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins="*")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Response<UserDto>> seeUserInfo(@PathVariable("id") Long id){
		log.info("Show information of user {}", id);
		Response<UserDto> response = new Response<UserDto>();
		
		Optional<Person> person = personService.findById(id);
		
		if(!person.isPresent()) {
			log.error("User {} does not exist!", id);
			response.addErrors("User " + id + " does not exist.");
			return ResponseEntity.badRequest().body(response);
		}
		
		//convert person to UserDto
		UserDto userDto = convertPersonToUserDto(person.get());
		response.setData(userDto);
		return ResponseEntity.ok(response);
	}
	
	private UserDto convertPersonToUserDto(Person person) {
		UserDto dto = new UserDto();
		
		dto.setName(person.getName());
		dto.setEmail(person.getEmail());
		dto.setId(person.getId());
		dto.setCpf(person.getCpf());
		dto.setAccounts(Optional.of(person.getAccounts()));
		dto.setPassword(person.getPassword());		
		
		log.info("---------->>> number of cards = "+person.getCards().size());
	
		person.getCards().forEach(card -> dto.addCardsNicknames(card.getNickname()));
		
//		dto.setCardsNicknames(Optional.of(person.getCards()));
		
		return dto;
	}
}
