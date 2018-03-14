package org.twinnation.springjpahibernatehowto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.twinnation.springjpahibernatehowto.manytoone.model.Bowl;
import org.twinnation.springjpahibernatehowto.manytoone.model.Fruit;
import org.twinnation.springjpahibernatehowto.manytoone.repository.BowlRepository;
import org.twinnation.springjpahibernatehowto.manytoone.repository.FruitRepository;


@Service
public class ManyToOneService {
	
	@Autowired
	private FruitRepository fruitRepository;
	
	@Autowired
	private BowlRepository bowlRepository;
	
	
	public Fruit createFruit(Fruit fruit) {
		return fruitRepository.save(fruit);
	}
	
	
	public Bowl createBowl(Bowl bowl) {
		return bowlRepository.save(bowl);
	}
	
}
