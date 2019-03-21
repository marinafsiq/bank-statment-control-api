package com.marinafsiq.bankStatmentControl.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.repositories.PersonRepository;
import com.marinafsiq.bankStatmentControl.api.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Optional<Person> findByCpf(String cpf) {
		log.info("Finding a person by the cpf number: {}", cpf);
		Person person = personRepository.findByCpf(cpf);
		return Optional.ofNullable(person);
	}

	@Override
	public Optional<Person> findByEmail(String email) {
		log.info("Finding a person by the email address: {}", email);
		Person person = personRepository.findByEmail(email);
		return Optional.ofNullable(person);
	}

	@Cacheable("personPerId")
	public Optional<Person> findById(Long id) {
		log.info("Finding a person by id: {}", id);
		Person person = personRepository.findById(id);
		return Optional.ofNullable(person);
	}
	
	@CachePut("personPerId")
	public Person persist(Person person) {
		log.info("Saving person {}", person.getName());
		Person per = personRepository.save(person);
		return per;
	}


}
