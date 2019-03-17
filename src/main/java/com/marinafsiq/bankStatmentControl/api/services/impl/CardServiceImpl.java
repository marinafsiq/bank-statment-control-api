package com.marinafsiq.bankStatmentControl.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinafsiq.bankStatmentControl.api.entitiess.Card;
import com.marinafsiq.bankStatmentControl.api.repositories.CardRepository;
import com.marinafsiq.bankStatmentControl.api.services.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	private static Logger log = LoggerFactory.getLogger(CardServiceImpl.class);
	
	@Autowired
	private CardRepository cardRepository;

	@Override
	public Optional<Card> findByNickname(String nickname) {
		log.info("Searching card by its nickname {}", nickname);
		Card card = cardRepository.findByNickname(nickname);
		return Optional.ofNullable(card);
	}

	@Override
	public Optional<Card> findByNumber(int number) {
		log.info("Searching card by its number {}", number);
		Card card = cardRepository.findByNumber(number);
		return Optional.ofNullable(card);
	}

	@Override
	public Card persist(Card card) {
		log.info("Saving card ({} - {}) in the database", card.getNickname(), card.getNumber());
		cardRepository.save(card);
		return card;
	}

}
