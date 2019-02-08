package com.marinafsiq.bankStatmentControl.api.entities;

import java.util.ArrayList;

public class Classification {
	
	private Long id;
	private String nome;
	private ArrayList<SubClassification> subClassification;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<SubClassification> getSubClassification() {
		return subClassification;
	}
	public void setSubClassification(ArrayList<SubClassification> subClassification) {
		this.subClassification = subClassification;
	}
	
	

}
