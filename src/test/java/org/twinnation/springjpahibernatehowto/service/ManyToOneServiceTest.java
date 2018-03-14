package org.twinnation.springjpahibernatehowto.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.twinnation.springjpahibernatehowto.manytoone.model.Bowl;
import org.twinnation.springjpahibernatehowto.manytoone.model.Fruit;
import org.twinnation.springjpahibernatehowto.manytoone.repository.BowlRepository;
import org.twinnation.springjpahibernatehowto.manytoone.repository.FruitRepository;

import java.util.Arrays;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class ManyToOneServiceTest {
	
	@Autowired private ManyToOneService service;
	@Autowired private FruitRepository fruitRepository;
	@Autowired private BowlRepository bowlRepository;
	
	
	@Test
	public void createFruit() throws Exception {
		Fruit fruit = service.saveFruit(new Fruit("Orange", null));
		assertEquals(fruit, fruitRepository.getOne(fruit.getId()));
	}
	
	
	@Test
	public void createBowl() throws Exception {
		Bowl bowl = new Bowl();
		Fruit orange = new Fruit("Orange", bowl);
		Fruit apple = new Fruit("Apple", bowl);
		bowl.setFruits(Arrays.asList(orange, apple));
		bowl = service.saveBowl(bowl);
		orange = fruitRepository.save(orange);
		apple = fruitRepository.save(apple);
		assertEquals(bowl, bowlRepository.getOne(bowl.getId()));
		assertEquals(bowl, fruitRepository.getOne(orange.getId()).getBowl());
		assertEquals(Arrays.asList(orange, apple), bowlRepository.getOne(bowl.getId()).getFruits());
	}
	
}