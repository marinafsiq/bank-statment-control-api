package com.marinafsiq.bankStatmentControl.api.entitiess;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.marinafsiq.bankStatmentControl.api.enums.PerfilEnum;

@Entity
@Table(name = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 4763869710847384492L;
	
	private Long id;
	private PerfilEnum perfil;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private List<Account> accounts;
	private List<Card> cards;
	private List<Purchase> purchases;
	
	
	public Person() {}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Account> getAccounts() {
		if(accounts==null)
			accounts = new ArrayList<Account>();
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Card> getCards() {
		if(cards==null)
			cards = new ArrayList<Card>();
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Purchase> getPurchases() {
		if(purchases==null)
			purchases = new ArrayList<Purchase>();
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	

}
