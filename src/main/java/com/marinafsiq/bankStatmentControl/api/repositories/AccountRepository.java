package com.marinafsiq.bankStatmentControl.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Account;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "AccountRepository.findByPersonId", 
		query = "SELECT acc FROM account acc WHERE acc.person.id = :personId"),
	@NamedQuery(name = "AccountRepository.findByPersonCpf", 
		query = "SELECT acc FROM account acc WHERE acc.person.cpf = :personCpf"),
	@NamedQuery(name = "AccountRepository.findByPersonId", 
		query = "SELECT acc FROM account acc WHERE acc.person.email = :personEmail")})
public interface AccountRepository extends JpaRepository<Account, Long>{

	//find by agency and account
	Account findByAgencyAndAccount(int agency, int account);

	//find by person Id
	List<Account> findByPersonId(@Param("personId") Long personId);
	
	//find by person cpf
	List<Account> findByPersonCpf(@Param("personCpf") Long personCpf);
	
	//find by person email
	List<Account> findByPersonEmail(@Param("personEmail") Long personEmail);

}
