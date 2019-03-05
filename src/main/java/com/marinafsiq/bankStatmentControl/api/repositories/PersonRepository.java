package com.marinafsiq.bankStatmentControl.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Person findByCpf(String cpf);
	
	Person findByEmail(String email);

}
