package com.marinafsiq.bankStatmentControl.api.entities;

import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classification")
public class Classification implements Serializable{
	
	private static final long serialVersionUID = 5967658794913900679L;
	
	private Long id;
	private String name;
	private ArrayList<SubClassification> subClassification;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "classification", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<SubClassification> getSubClassification() {
		return subClassification;
	}
	public void setSubClassification(ArrayList<SubClassification> subClassification) {
		this.subClassification = subClassification;
	}
	
	

}
