package org.twinnation.springjpahibernatehowto.onetoone.model;

import javax.persistence.*;


@Entity
public class CPU {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelName;
	
	
	public CPU(String modelName) {
		this.modelName = modelName;
	}
	
	
	public CPU() {}
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getModelName() {
		return modelName;
	}
	
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
}
