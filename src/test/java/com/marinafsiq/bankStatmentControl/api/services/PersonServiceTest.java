package com.marinafsiq.bankStatmentControl.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {
	
	@MockBean
	private PersonRepository personRepository;
	
	@Autowired
	private PersonService personService;
	
	private static final String CPF = "064.158.236-94";
	
	
	@Before
	public void setUp() {
		BDDMockito.given(personRepository.findByCpf(Mockito.anyString())).willReturn( new Person());
		BDDMockito.given(personRepository.save(Mockito.any(Person.class))).willReturn(new Person());
	}
	
	
	@Test
	public void findByCpfTest() {
		Optional<Person> person = personService.findByCpf(CPF);
		assertTrue(person.isPresent());
	}
	
	@Test
	public void persistTest() {
		Person person = personService.persist(new Person());
		assertNotNull(person);
	}

}
