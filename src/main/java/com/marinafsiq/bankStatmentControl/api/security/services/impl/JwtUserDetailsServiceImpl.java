package com.marinafsiq.bankStatmentControl.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.security.JwtUserFactory;
import com.marinafsiq.bankStatmentControl.api.services.PersonService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private PersonService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> user = userService.findByEmail(username);
		
		if(user.isPresent())
			return JwtUserFactory.create(user.get());
		
		throw new UsernameNotFoundException("Email não encontrado");
	}

}
