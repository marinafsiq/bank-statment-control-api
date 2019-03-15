package com.marinafsiq.bankStatmentControl.api.controllers;

import java.security.NoSuchAlgorithmException;
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

import com.marinafsiq.bankStatmentControl.api.dtos.SignUpPersonDto;
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.enums.PerfilEnum;
import com.marinafsiq.bankStatmentControl.api.response.Response;
import com.marinafsiq.bankStatmentControl.api.services.PersonService;
import com.marinafsiq.bankStatmentControl.api.utils.PasswordUtils;


@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "*")
public class SignUpPersonController {
	
	private static final Logger log = LoggerFactory.getLogger(SignUpPersonController.class);
	
	@Autowired
	private PersonService personService;
	
	
	/**
	 * Sign up a Person in the system
	 * 
	 * @param signUpPersonDto
	 * @param result
	 * @return ResponseEntity<Response<SignUpPersonDto>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping
	public ResponseEntity<Response<SignUpPersonDto>> signUp(@Valid @RequestBody SignUpPersonDto signUpPersonDto,
			BindingResult result) throws NoSuchAlgorithmException{
		Response<SignUpPersonDto> response = new Response<SignUpPersonDto>();
		
		log.info("Signing up Person {}", signUpPersonDto);
		
		//check if this Person already exists
		checkIfPersonAlreadyExists(signUpPersonDto, result);
		
		
		//check if result has errors and return the response with the errors
		if(result.hasErrors()) {
			log.error("Error validating Person sign up: {}", result.getAllErrors());
			
			result.getAllErrors().forEach(er -> response.addErrors(er.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		//convert SignUpPersonDto into Person
		Person person = convertSignUpPersonDtoIntoPerson(signUpPersonDto);
		//persist person in the database using PersonService
		personService.persist(person);
		
		//complete the dto with the new info from Person
		signUpPersonDto.setId(person.getId());
		
		//return the response with the dto
		response.setData(signUpPersonDto);
		
		return ResponseEntity.ok(response);
	}
	
	private void checkIfPersonAlreadyExists(SignUpPersonDto signUpPersonDto, BindingResult result) {
		Optional<Person> person = personService.findByCpf(signUpPersonDto.getCpf());
		
		if(person.isPresent()) 
			result.addError(new ObjectError("Person", "A person with this CPF already exists"));
		
		personService.findByEmail(signUpPersonDto.getEmail()).ifPresent(per -> result.addError(new ObjectError("Person", "A person with this CPF already exists")));
			
	}
	
	private Person convertSignUpPersonDtoIntoPerson(SignUpPersonDto signUpPersonDto) {
		Person person = new Person();
		person.setName(signUpPersonDto.getName());
		person.setCpf(signUpPersonDto.getCpf());
		person.setEmail(signUpPersonDto.getEmail());
		person.setPassword(PasswordUtils.gerarBCrypt(signUpPersonDto.getPassword()));
		person.setPerfil(PerfilEnum.ROLE_USUARIO);
		signUpPersonDto.getCards().ifPresent(car -> person.setCards(car));
		signUpPersonDto.getAccounts().ifPresent(accounts -> person.setAccounts(accounts));
		
		return person;
	}
	
	

}
