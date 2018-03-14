package org.twinnation.springjpahibernatehowto.onetoone.model;

import javax.persistence.*;


@Entity
public class Motherboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelName;
	
	@OneToOne
	@JoinColumn(name = "cpu_id")
	private CPU cpu;
	
	
	public Motherboard(String modelName, CPU cpu) {
		this.modelName = modelName;
		this.cpu = cpu;
	}
	
	
	public Motherboard(String modelName) {
		this.modelName = modelName;
	}
	
	
	public Motherboard() {}
	
	
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
	
	
	public CPU getCpu() {
		return cpu;
	}
	
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
}
