package com.marinafsiq.bankStatmentControl.api.entities;

import java.util.Date;

public class Purchase {
	private Long id;
	private String purchase;
	private Date dateTime;
	private float price;
	private Classification classification;
	private SubClassification subClassification;
	private NotaFiscal notaFiscal;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	public SubClassification getSubClassification() {
		return subClassification;
	}
	public void setSubClassification(SubClassification subClassification) {
		this.subClassification = subClassification;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	

}
