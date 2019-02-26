package com.marinafsiq.bankStatmentControl.api.entitiess;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 3484313084511177507L;
	
	private long id;
	private int numOrder;
	private int code;
	private String description;
	private float quantity;
	private String unit;
	private float unitValue;
	private float itemValue;
	private NotaFiscal notaFiscal;
	
	public Product() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "num_order", nullable = false)
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	
	@Column(name = "code", nullable = false)
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "quantity", nullable = false)
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "unit", nullable = false)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Column(name = "unit_value", nullable = false)
	public float getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(float unitValue) {
		this.unitValue = unitValue;
	}
	
	@Column(name = "item_value", nullable = false)
	public float getItemValue() {
		return itemValue;
	}
	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	
	
	

}
