package com.marinafsiq.bankStatmentControl.api.dtos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.marinafsiq.bankStatmentControl.api.entitiess.Purchase;

public class CardDto {
	
	private Optional<Long> id = Optional.empty();
	private String nickname;
	private int number;
	private Date expireDate;
	private Optional<List<Purchase>> purchases = Optional.empty();
	private Long personId;
	
	public Optional<Long> getId() {
		return id;
	}
	public void setId(Optional<Long> id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nickname must be filled.")
	@Length(min=3, max=20, message="Nickname should have between 3 and 20 characters")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@NotNull(message = "Card number must be filled.")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@DateTimeFormat
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	public Optional<List<Purchase>> getPurchases() {
		return purchases;
	}
	public void setPurchases(Optional<List<Purchase>> purchases) {
		this.purchases = purchases;
	}
	
	@NotNull
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	@Override
	public String toString() {
		return String.format("card: [number=%d, nickName=%s]", number, nickname);
	}
	

}
