package com.marinafsiq.bankStatmentControl.api.entities;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {
	
	private Long id;
	private String establishmentCnpj;
	private String estrablishmentName;
	private int numNota;
	private Date issuedDate;
	private float value;
	private Date registrationDate;
	private float credit;
	private float creditSituation;
	private ArrayList<Product> products;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstablishmentCnpj() {
		return establishmentCnpj;
	}
	public void setEstablishmentCnpj(String establishmentCnpj) {
		this.establishmentCnpj = establishmentCnpj;
	}
	public String getEstrablishmentName() {
		return estrablishmentName;
	}
	public void setEstrablishmentName(String estrablishmentName) {
		this.estrablishmentName = estrablishmentName;
	}
	public int getNumNota() {
		return numNota;
	}
	public void setNumNota(int numNota) {
		this.numNota = numNota;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public float getCreditSituation() {
		return creditSituation;
	}
	public void setCreditSituation(float creditSituation) {
		this.creditSituation = creditSituation;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	

}
