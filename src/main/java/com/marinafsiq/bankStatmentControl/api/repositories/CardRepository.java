package com.marinafsiq.bankStatmentControl.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Card;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "CardRepository.findByPersonId", 
		query = "SELECT ca FROM card ca WHERE ca.person.id = :personId"),
	@NamedQuery(name = "AccountRepository.findByPersonCpf", 
		query = "SELECT ca FROM card ca WHERE ca.person.cpf = :personCpf"),
	@NamedQuery(name = "AccountRepository.findByPersonId", 
		query = "SELECT ca FROM card ca WHERE ca.person.email = :personEmail")})
public interface CardRepository extends JpaRepository<Card, Long>{

	//find by nickname
	Card findByNickname(String nickname);
	
	//find by number
	Card findByNumber(int number);

	//find by person Id
	List<Card> findByPersonId(@Param("personId") Long personId);
	
	//find by person cpf
	List<Card> findByPersonCpf(@Param("personCpf") Long personCpf);
	
	//find by person email
	List<Card> findByPersonEmail(@Param("personEmail") Long personEmail);

}
