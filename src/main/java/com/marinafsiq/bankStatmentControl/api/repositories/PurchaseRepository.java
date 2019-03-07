package com.marinafsiq.bankStatmentControl.api.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "PurchaseRepository.findByPersonId", 
		query = "SELECT pur FROM purchase pur WHERE pur.person.id = :personId"),
	@NamedQuery(name = "PurchaseRepository.findByPersonCpf", 
		query = "SELECT pur FROM purchase pur WHERE pur.person.cpf = :personCpf"),
	@NamedQuery(name = "PurchaseRepository.findByAccountAgencyAndAccountAccount", 
		query = "SELECT pur FROM purchase pur WHERE pur.account.agency = :agency AND pur.account.account = :account"),
	@NamedQuery(name = "PurchaseRepository.findByCardNickname", 
		query = "SELECT pur FROM purchase pur WHERE pur.card.nickname = :cardNickname"),
	@NamedQuery(name = "PurchaseRepository.findByClassificationName", 
		query = "SELECT pur FROM purchase pur WHERE pur.classification.name = :classificationName")})
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	//find by person (id, cpf, email)
	List<Purchase> findByPersonId(@Param("personId") Long personId);
	List<Purchase> findByPersonCpf(@Param("personCpf") String personCpf);
	
	//find by account (id, ageny and account)
	List<Purchase> findByAccountAgencyAndAccountAccount(@Param("agency") int agency, @Param("account") int account);
	
	//find by card (id, nickname)
	List<Purchase> findByCardNickname(@Param("cardNickname") String cardNickname);
	
	//find by date between x and y
	List<Purchase> findByDateTimeBetween(Date d1, Date d2);
	
	//find purchases where classification is equal xxx
	List<Purchase> findByClassificationName(@Param("classificationName") String classificationName);
}
