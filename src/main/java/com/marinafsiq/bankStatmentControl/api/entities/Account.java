package com.marinafsiq.bankStatmentControl.api.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.marinafsiq.bankStatmentControl.api.enums.BankEnum;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	
	private static final long serialVersionUID = -903921164858973921L;
	
	private Long id;
	private BankEnum bank;
	private int account;
	private int agency;
	private String password;
	private Person pessoa;
	private ArrayList<Purchase> purchases;
	private ArrayList<Card> cards;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "bank", nullable = false)
	public BankEnum getBank() {
		return bank;
	}
	public void setBank(BankEnum bank) {
		this.bank = bank;
	}
	
	@Column(name = "account", nullable = false)
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	@Column(name = "agency", nullable = false)
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Person getPessoa() {
		return pessoa;
	}
	public void setPessoa(Person pessoa) {
		this.pessoa = pessoa;
	}
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
	
		

}
