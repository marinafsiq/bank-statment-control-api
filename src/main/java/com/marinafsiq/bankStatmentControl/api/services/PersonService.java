package com.marinafsiq.bankStatmentControl.api.services;

import java.util.Optional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;

public interface PersonService {
	
	/**
	 * Return a Person given his/her CPF
	 * @param cpf
	 * @return Optional<Person>
	 * */
	Optional<Person> findByCpf(String cpf);
	
	
	/**
	 * Return a Person given his/her e-mail
	 * @param email
	 * @return Optional<Person>
	 * */
	Optional<Person> findByEmail(String email);
	
	/**
	 * Return a Person given his/her id
	 * @param id
	 * @return Optional<Person>
	 * */
	Optional<Person> findById(Long id);
	
	/**
	 * Persist/Save a new person in the database
	 * @param person
	 * @return Person
	 * */
	Person persist(Person person);

}
