package org.twinnation.springjpahibernatehowto.manytoone.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Bowl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "bowl")
	private List<Fruit> fruits;
	
	
	public Bowl(List<Fruit> fruits) {
		this.fruits = fruits;
	}
	
	
	public Bowl() {}
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Fruit> getFruits() {
		return fruits;
	}
	
	
	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}
	
}
