package com.marinafsiq.bankStatmentControl.api.entities;

import com.marinafsiq.bankStatmentControl.api.enums.BankEnum;

public class Account {
	
	private Long id;
	private BankEnum bank;
	private int account;
	private int agency;
	private String password;
	private Person pessoa;
	private String category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public BankEnum getBank() {
		return bank;
	}
	public void setBank(BankEnum bank) {
		this.bank = bank;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPessoa() {
		return pessoa;
	}
	public void setPessoa(Person pessoa) {
		this.pessoa = pessoa;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
