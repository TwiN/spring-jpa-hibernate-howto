package org.twinnation.springjpahibernatehowto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.twinnation.springjpahibernatehowto.manytoone.model.Bowl;
import org.twinnation.springjpahibernatehowto.manytoone.model.Fruit;
import org.twinnation.springjpahibernatehowto.onetoone.model.CPU;
import org.twinnation.springjpahibernatehowto.onetoone.model.Motherboard;
import org.twinnation.springjpahibernatehowto.service.ManyToOneService;
import org.twinnation.springjpahibernatehowto.service.OneToOneService;

import java.io.IOException;
import java.util.Arrays;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class SpringJpaHibernateHowtoApplication {

	@Autowired private OneToOneService oneToOneService;
	@Autowired private ManyToOneService manyToOneService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateHowtoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner init() throws IOException {
		return (args) -> {
			CPU cpu = new CPU("Intel Core i7-8700K Processor");
			Motherboard motherboardWithCpu = new Motherboard("Asus ROG Maximus IX Formula", cpu);
			oneToOneService.saveCPU(cpu);
			oneToOneService.saveMotherboard(motherboardWithCpu);
			
			Bowl bowl = manyToOneService.saveBowl(new Bowl());
			Fruit orange = manyToOneService.saveFruit(new Fruit("Orange", bowl));
			Fruit apple = manyToOneService.saveFruit(new Fruit("Apple", bowl));
			Fruit lemon = manyToOneService.saveFruit(new Fruit("Lemon", bowl));
			bowl.setFruits(Arrays.asList(orange, apple, lemon));
		};
	}
	
}
