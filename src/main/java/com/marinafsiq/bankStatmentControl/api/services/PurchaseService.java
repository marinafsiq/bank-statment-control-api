package com.marinafsiq.bankStatmentControl.api.services;

import java.util.Date;
import java.util.List;

import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;

public interface PurchaseService {
	
	/*
	 * 
	List<Purchase> findByPersonId(@Param("personId") Long personId);
	List<Purchase> findByPersonCpf(@Param("personCpf") String personCpf);
	List<Purchase> findByAccountAgencyAndAccountAccount(@Param("agency") int agency, @Param("account") int account);
	List<Purchase> findByCardNickname(@Param("cardNickname") String cardNickname);
	List<Purchase> findByDateTimeBetween(Date d1, Date d2);
	List<Purchase> findByClassificationName(@Param("classificationName") String classificationName);
	 * */
	
	/**
	 * Return purchases by person Id
	 * @param id
	 * @return List<Purchase>
	 * */
	List<Purchase> findByPersonId(Long id);
	
	/**
	 * Return purchases by person cpf
	 * @param cpf
	 * @return List<Purchase>
	 * */
	List<Purchase> findByPersonCpf(String cpf);
	
	/**
	 * Return purchases by agency and account
	 * @param agency and account
	 * @return List<Purchase>
	 * */
	List<Purchase> findByAgencyAndAccount(int agency, int account);
	
	/**
	 * Return purchases by card nickname
	 * @param cardNickname
	 * @return List<Purchase>
	 * */
	List<Purchase> findByCardNickname(String cardNickname);
	
	/**
	 * Return purchases by DataTime range
	 * @param date 1 and date 2
	 * @return List<Purchase>
	 * */
	List<Purchase> findByDateTimeBetween(Date d1, Date d2);
	
	/**
	 * Return purchases by classification name
	 * @param classification name
	 * @return List<Purchase>
	 * */
	List<Purchase> findByClassificationName(String classificationName);
	
	/**
	 * Save a new purchase in the database
	 * @param purchase
	 * @return Purchase
	 * */
	Purchase persist(Purchase purchase);


}
