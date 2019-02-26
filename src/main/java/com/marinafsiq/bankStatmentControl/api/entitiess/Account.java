package com.marinafsiq.bankStatmentControl.api.entitiess;

import java.io.Serializable;
import java.util.List;

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
	private Person person;
	private List<Purchase> purchases;
	private List<Card> cards;

	
	public Account() {}
	
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
		

}
