package com.marinafsiq.bankStatmentControl.api.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.marinafsiq.bankStatmentControl.api.entitiess.Account;
import com.marinafsiq.bankStatmentControl.api.entitiess.Card;

public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private Optional<List<Account>> accounts = Optional.empty(); //optional. não precisa adicionar Accounts ao ao fazer sign in. Isso pode ser adicionado posteriormente.
	private Optional<List<String>> cardsNicknames = Optional.empty(); //optional. não precisa adicionar Cards ao ao fazer sign in. Isso pode ser adicionado posteriormente.
	//private List<Purchase> purchases; ao fazer 'sign in' a pessoa não adiciona compras
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Name must be filled.")
	@Length(min = 3, max = 200, message = "Name should have between 3 and 200 characters")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message = "E-mail must be filled.")
	@Length(min = 6, max = 200, message = "E-mail should have between 6 and 200 characters")
	@Email(message = "This e-mail is no valid.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message = "Password must be filled.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotEmpty(message = "CPF must be filled.")
	@CPF(message = "This CPF is not valid.")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Optional<List<Account>> getAccounts() {
		return accounts;
	}
	public void setAccounts(Optional<List<Account>> accounts) {
		this.accounts = accounts;
	}	
	
	public Optional<List<String>> getCardsNicknames() {
		return cardsNicknames;
	}
	public void setCardsNicknames(Optional<List<String>> cardNickname) {
		this.cardsNicknames = cardNickname;
	}
	public void addCardsNicknames(String cardNickname) {
		if(!cardsNicknames.isPresent())
			cardsNicknames = Optional.of(new ArrayList<String>());
		
		this.cardsNicknames.get().add(cardNickname);
	}
	
	@Override
	public String toString() {
		String res = String.format("PersonDto: {id=%d, name=%s, email=%s, password=%s, cpf=%d, num of cards=%d, num of accounts=%d}",
						id, name, email, password, cpf, cardsNicknames.get().size(), accounts.get().size());
		return res;
	}
	

}
