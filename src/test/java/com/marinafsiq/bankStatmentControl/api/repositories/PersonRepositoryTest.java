package com.marinafsiq.bankStatmentControl.api.repositories;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.utils.ModelObjectsGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonRepositoryTest {
		
	@Autowired
	private PersonRepository personRepository;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setup test");
		
		Person person = ModelObjectsGenerator.getPersonObject();
		this.personRepository.save(person);
	}
	
	@After
	public void tearDown() {
		this.personRepository.deleteAll();
	}
	
	@Test
	public void testFindByCpf(){
		Person person = this.personRepository.findByCpf(ModelObjectsGenerator.CPF);
		assertEquals(ModelObjectsGenerator.CPF, person.getCpf());
	}
	
	@Test
	public void testFindByEmail() {
		Person person = this.personRepository.findByEmail(ModelObjectsGenerator.EMAIL);
		assertEquals(ModelObjectsGenerator.EMAIL, person.getEmail());
	}
	

}
