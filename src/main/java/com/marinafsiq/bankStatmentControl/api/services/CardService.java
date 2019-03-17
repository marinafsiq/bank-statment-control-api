package com.marinafsiq.bankStatmentControl.api.services;

import java.util.Optional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Card;

public interface CardService {
	
	//find by nickname
	Optional<Card> findByNickname(String nickname);
		
	//find by number
	Optional<Card> findByNumber(int number);
	
	/**
	 * Persist/Save a new person in the database
	 * @param person
	 * @return Person
	 * */
	Card persist(Card card);

}
