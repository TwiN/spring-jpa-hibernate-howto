package org.twinnation.springjpahibernatehowto.manytoone.model;

import javax.persistence.*;


@Entity
public class Fruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "bowl_id")
	private Bowl bowl;
	
	
	public Fruit(String name, Bowl bowl) {
		this.name = name;
		this.bowl = bowl;
	}
	
	
	public Fruit() {}
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Bowl getBowl() {
		return bowl;
	}
	
	
	public void setBowl(Bowl bowl) {
		this.bowl = bowl;
	}
	
}
