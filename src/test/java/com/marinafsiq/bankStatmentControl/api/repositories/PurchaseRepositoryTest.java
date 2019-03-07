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
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;
import com.marinafsiq.bankStatmentControl.api.utils.ModelObjectsGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PurchaseRepositoryTest {
	
	@Autowired
	public PurchaseRepository purchaseRepository;
	
	@Autowired
	public PersonRepository personRepository;
	
	@Autowired
	public AccountRepository accountRepository;
	
	@Before
	public void setUp() {
		//criar objetos e salvar no banco
		List<Purchase> purchases = ModelObjectsGenerator.getPurchasesObject();
		Person person = ModelObjectsGenerator.getPersonObject();
		person.setPurchases(purchases);
		purchases.get(0).setPerson(person);
		purchases.get(1).setPerson(person);
		
		Account account = ModelObjectsGenerator.getAccountObject();
		purchases.get(0).setAccount(account);
		
		this.accountRepository.save(account);
		this.personRepository.save(person);
		this.purchaseRepository.saveAll(purchases);
	}
	
	@After
	public void tearDown() {
		//apagar todos os 
		this.purchaseRepository.deleteAll();
		this.personRepository.deleteAll();
		this.accountRepository.deleteAll();
	}
	
	@Test
	public void testFindByPersonCpf() {
		List<Purchase> purchases = this.purchaseRepository.findByPersonCpf(ModelObjectsGenerator.CPF);
		assertEquals(2, purchases.size());
	}
	
	@Test
	public void testFindByPersonId() {
		Person person = this.personRepository.findByCpf(ModelObjectsGenerator.CPF);
		List<Purchase> purchases = this.purchaseRepository.findByPersonId(person.getId());
		assertEquals(2, purchases.size());
	}

	@Test
	public void testFindByAccountAgencyAndAccountAccount() {
		List<Purchase> purchases = this.purchaseRepository.findByAccountAgencyAndAccountAccount(ModelObjectsGenerator.AGENCY, ModelObjectsGenerator.ACCOUNT);
		assertEquals(1, purchases.size());
	}
}
