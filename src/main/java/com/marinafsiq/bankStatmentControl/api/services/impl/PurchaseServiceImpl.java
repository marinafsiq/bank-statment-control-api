package com.marinafsiq.bankStatmentControl.api.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;
import com.marinafsiq.bankStatmentControl.api.repositories.PurchaseRepository;
import com.marinafsiq.bankStatmentControl.api.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	private static final Logger log = LoggerFactory.getLogger(PurchaseServiceImpl.class);
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public List<Purchase> findByPersonId(Long id) {
		log.info("Finding purchases by person id: {}", id);
		return purchaseRepository.findByPersonId(id);
	}

	@Override
	public List<Purchase> findByPersonCpf(String cpf) {
		log.info("Finding purchases by person cpf: {}", cpf);
		return purchaseRepository.findByPersonCpf(cpf);
	}

	@Override
	public List<Purchase> findByAgencyAndAccount(int agency, int account) {
		log.info("Finding purchases by agency={} and account={}", agency, account);
		return purchaseRepository.findByAccountAgencyAndAccountAccount(agency, account);
	}

	@Override
	public List<Purchase> findByCardNickname(String cardNickname) {
		log.info("Finding purchases by card nickname: {}", cardNickname);
		return purchaseRepository.findByCardNickname(cardNickname);
	}

	@Override
	public List<Purchase> findByDateTimeBetween(Date d1, Date d2) {
		log.info("Finding purchases between dates {} and {}", d1, d2);
		return purchaseRepository.findByDateTimeBetween(d1, d2);
	}

	@Override
	public List<Purchase> findByClassificationName(String classificationName) {
		log.info("Finding purchases by classification name: {}", classificationName);
		return purchaseRepository.findByClassificationName(classificationName);
	}

	@Override
	public Purchase persist(Purchase purchase) {
		log.info("Saving purchase in the database: {}", purchase.getPurchase());
		return purchaseRepository.save(purchase);
	}

}
