package com.marinafsiq.bankStatmentControl.api.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils {
	
	static final String CLAIM_KEY_USERNAME = "sub"; //sub de subject
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	
	/**
	 *Get the username (e-mail) 'contido' in the JWT token 
	 * @param token
	 * @return username
	 **/
	public String getUsernameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		}catch(Exception e){
			username = null;
		}
		return username;
	}
	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		}catch(Exception e) {
			expiration = null;
		}
		return expiration;
	}
	
	public String refreshToken(String token){
		String newToken;
		try{
			Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			newToken = generateToken(claims);
		}catch(Exception e){
			newToken = null;
		}
		return newToken;
	}
	
	/**
	 * Check if the token is valid and return the answer for this
	 * @param token
	 * @return a boolean to say if the token is valid or not
	 */
	public boolean isTokenValid(String token) {
		return !tokenExpired(token);
	}
	
	private boolean tokenExpired(String token) {
		Date expirationDate = this.getExpirationDateFromToken(token);
		if(expirationDate==null)
			return false;
		return expirationDate.before(new Date());
	}
	 
	
	/**
	 *Generate a new JWT token with the data (claims) provided 
	 * @param claims
	 * @return newToken
	 */
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}	
	
	/**
	 * Generate expiration date based in current date
	 */
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis()+expiration*1000);
	}
	
	
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}catch(Exception e) {
			claims = null;
		}
		return claims;
	}
	
	/**
	 *Returns a new JWT token based on user data; 
	 */
	public String getToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}
	 

}
