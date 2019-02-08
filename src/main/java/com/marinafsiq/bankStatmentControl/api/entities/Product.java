package com.marinafsiq.bankStatmentControl.api.entities;

public class Product {
	
	private int numOrder;
	private int code;
	private String description;
	private float quantity;
	private String unit;
	private float unitValue;
	private float itemValue;
	private NotaFiscal notaFiscal;
	
	
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(float unitValue) {
		this.unitValue = unitValue;
	}
	public float getItemValue() {
		return itemValue;
	}
	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	
	

}
