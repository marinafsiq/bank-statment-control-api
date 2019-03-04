package com.marinafsiq.bankStatmentControl.api.entitiess;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable{
	
	private static final long serialVersionUID = -7223760143350778787L;
	
	private Long id;
	private String establishmentCnpj;
	private String estrablishmentName;
	private int numNota;
	private Date issuedDate;
	private float value;
	private Date registrationDate;
	private float credit;
	private float creditSituation;
	private Purchase purchase; 
	private List<Product> products;
	
	public NotaFiscal() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "establishment_cnpj", nullable = false)
	public String getEstablishmentCnpj() {
		return establishmentCnpj;
	}
	public void setEstablishmentCnpj(String establishmentCnpj) {
		this.establishmentCnpj = establishmentCnpj;
	}
	
	@Column(name = "establishment_name", nullable = false)
	public String getEstrablishmentName() {
		return estrablishmentName;
	}
	public void setEstrablishmentName(String estrablishmentName) {
		this.estrablishmentName = estrablishmentName;
	}
	
	@Column(name = "num_nota", nullable = false)
	public int getNumNota() {
		return numNota;
	}
	public void setNumNota(int numNota) {
		this.numNota = numNota;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "issued_date", nullable = false)
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	
	@Column(name = "value", nullable = false)
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registation_date", nullable = true)
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Column(name = "credit", nullable = true)
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	
	@Column(name = "credit_situation", nullable = true)
	public float getCreditSituation() {
		return creditSituation;
	}
	public void setCreditSituation(float creditSituation) {
		this.creditSituation = creditSituation;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	@OneToMany(mappedBy = "notaFiscal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
