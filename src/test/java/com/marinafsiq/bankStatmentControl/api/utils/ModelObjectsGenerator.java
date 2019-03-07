package com.marinafsiq.bankStatmentControl.api.utils;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.marinafsiq.bankStatmentControl.api.entitiess.Account;
import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;
import com.marinafsiq.bankStatmentControl.api.enums.BankEnum;
import com.marinafsiq.bankStatmentControl.api.enums.PaymentMathodEnum;
import com.marinafsiq.bankStatmentControl.api.enums.PaymentTypeEnum;
import com.marinafsiq.bankStatmentControl.api.enums.PerfilEnum;

public class ModelObjectsGenerator {
	//cpf
	public static final String CPF = "064.158.236-94";
			
	//email
	public static final String EMAIL = "joaozinho@gmail.com";
	
	//account
	public static final int ACCOUNT = 158061;
	public static final int AGENCY = 1238;
	
	public static Person getPersonObject() {
		Person person = new Person();
		person.setPerfil(PerfilEnum.ROLE_USUARIO);
		person.setName("Joaozinho Pereira da Silva");
		person.setEmail(EMAIL);
		person.setPassword(PasswordUtils.gerarBCrypt("123456789"));
		person.setCpf(CPF);
		return person;
	}
	
	public static Purchase getPurchaseObject() {
		Purchase purchase1 = new Purchase();
		GregorianCalendar gc = new GregorianCalendar(2019, 06, 03, 11, 55);
		purchase1.setDateTime(gc.getTime());
		purchase1.setPaymentMethod(PaymentMathodEnum.CREDIT);
		purchase1.setPaymentType(PaymentTypeEnum.SPOT);
		purchase1.setPrice((float) 16.95);
		purchase1.setPurchase("Suco detox de limao");
		purchase1.setTotalNumOfInstallment(0);
				
		return purchase1;
	}
	
	public static List<Purchase> getPurchasesObject() {
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(getPurchaseObject());
		
		Purchase purchase1 = new Purchase();
		GregorianCalendar gc = new GregorianCalendar(2019, 06, 04, 18, 31);
		purchase1.setDateTime(gc.getTime());
		purchase1.setPaymentMethod(PaymentMathodEnum.DEBIT);
		purchase1.setPaymentType(PaymentTypeEnum.SPOT);
		purchase1.setPrice((float) 35.90);
		purchase1.setPurchase("Camiseta infantil menina 6 anos");
		purchase1.setTotalNumOfInstallment(0);
		
		purchases.add(purchase1);		
		
		return purchases;
	}
	
	public static Account getAccountObject() {
		Account account = new Account();
		account.setAccount(ACCOUNT);
		account.setAgency(AGENCY);
		account.setBank(BankEnum.ITAU);
		account.setPassword(PasswordUtils.gerarBCrypt("123654879"));
		return account;
	}

}
