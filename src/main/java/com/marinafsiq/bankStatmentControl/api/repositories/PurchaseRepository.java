package com.marinafsiq.bankStatmentControl.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	//find by person (id, cpf, email)
	//find by account (id, ageny and account)
	//find by card (id, nickname)
	//find by date between x and y
	//find purchases where classification is equal xxx
	
}
