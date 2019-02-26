package com.marinafsiq.bankStatmentControl.api.entitiess;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.marinafsiq.bankStatmentControl.api.enums.PaymentMathodEnum;
import com.marinafsiq.bankStatmentControl.api.enums.PaymentTypeEnum;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable{
	
	private static final long serialVersionUID = -929784620430906726L;
	
	private Long id;
	private String purchase;
	private Date dateTime;
	private float price;
	private Classification classification;
	private SubClassification subClassification;
	private NotaFiscal notaFiscal;
	private Person person;
	private Account account;
	private Card card;
	private PaymentMathodEnum paymentMethod;
	private PaymentTypeEnum paymentType;
	private int currentInstallment;
	private int totalNumOfInstallment;
	
	public Purchase() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "purchase", nullable = false)
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time", nullable = false)
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	@Column(name = "price", nullable = false)
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public SubClassification getSubClassification() {
		return subClassification;
	}
	public void setSubClassification(SubClassification subClassification) {
		this.subClassification = subClassification;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	@Enumerated(EnumType.STRING)
	public PaymentMathodEnum getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMathodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Enumerated(EnumType.STRING)
	public PaymentTypeEnum getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentTypeEnum paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "current_installment", nullable=true)
	public int getCurrentInstallment() {
		return currentInstallment;
	}
	public void setCurrentInstallment(int currentInstallment) {
		this.currentInstallment = currentInstallment;
	}
	
	@Column(name = "total_num_of_installment", nullable=true)
	public int getTotalNumOfInstallment() {
		return totalNumOfInstallment;
	}
	public void setTotalNumOfInstallment(int totalNumOfInstallment) {
		this.totalNumOfInstallment = totalNumOfInstallment;
	}
	
	
	

}
