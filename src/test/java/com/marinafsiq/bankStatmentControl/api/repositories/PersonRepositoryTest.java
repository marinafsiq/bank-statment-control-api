package com.marinafsiq.bankStatmentControl.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.marinafsiq.bankStatmentControl.api.entitiess.Account;
import com.marinafsiq.bankStatmentControl.api.entitiess.Card;
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;
import com.marinafsiq.bankStatmentControl.api.enums.PerfilEnum;
import com.marinafsiq.bankStatmentControl.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonRepositoryTest {
	
	//cpf
	private static final String CPF = "064.158.236-94";
	
	//email
	private static final String EMAIL = "joaozinho@gmail.com";
	
	@Autowired
	private PersonRepository personRepository;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setup test");
		this.personRepository.save(getPersonObject());
	}
	
	@After
	public void tearDown() {
		this.personRepository.deleteAll();
	}
	
	@Test
	public void testFindByCpf(){
		Person person = this.personRepository.findByCpf(CPF);
		assertEquals(CPF, person.getCpf());
	}
	
	@Test
	public void testFindByEmail() {
		Person person = this.personRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, person.getEmail());
	}
	
	public Person getPersonObject() {
		Person person = new Person();
		person.setPerfil(PerfilEnum.ROLE_USUARIO);
		person.setName("Joaozinho Pereira da Silva");
		person.setEmail(EMAIL);
		person.setPassword(PasswordUtils.gerarBCrypt("123456789"));
		person.setCpf(CPF);
		return person;
	}

}
