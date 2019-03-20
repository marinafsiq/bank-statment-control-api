package com.marinafsiq.bankStatmentControl.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.marinafsiq.bankStatmentControl.api.entitiess.Person;
import com.marinafsiq.bankStatmentControl.api.enums.PerfilEnum;

public class JwtUserFactory {
	
	/**
	 * Convert and generate a JwtUser based on the 'person'(user) data
	 */
	public static JwtUser create(Person user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getPerfil()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

}
