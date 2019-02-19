package com.marinafsiq.bankStatmentControl.api.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subclassification")
public class SubClassification implements Serializable{
	
	private static final long serialVersionUID = 11857697920820407L;
	
	private Long id;
	private String name;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable=false)
	public String getName() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}

}
