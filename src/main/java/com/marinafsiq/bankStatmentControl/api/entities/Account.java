package com.marinafsiq.bankStatmentControl.api.entities;

public class Account {
	
	private Long id;
	private String bank;
	private int account;
	private int agency;
	private String password;
	private Person pessoa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
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
	
	

}
