package org.twinnation.springjpahibernatehowto.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.twinnation.springjpahibernatehowto.onetoone.model.CPU;
import org.twinnation.springjpahibernatehowto.onetoone.model.Motherboard;
import org.twinnation.springjpahibernatehowto.onetoone.repository.CPURepository;
import org.twinnation.springjpahibernatehowto.onetoone.repository.MotherboardRepository;

import java.util.Arrays;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToOneServiceTest {
	
	@Autowired
	private OneToOneService service;
	
	@Autowired
	private CPURepository cpuRepository;
	
	@Autowired
	private MotherboardRepository motherboardRepository;
	
	
	@Test
	public void createCPU() throws Exception {
		CPU cpu = service.saveCPU(new CPU("Intel Core i7-8700K Processor"));
		assertTrue(cpuRepository.existsById(cpu.getId()));
	}
	
	
	@Test
	public void createMotherboard() throws Exception {
		Motherboard motherboard = service.saveMotherboard(new Motherboard("Asus ROG Maximus IX Formula"));
		assertTrue(motherboardRepository.existsById(motherboard.getId()));
	}
	
	
	@Test
	public void createMotherboardWithCpu() throws Exception {
		CPU cpu = new CPU("Intel Core i7-8700K Processor");
		Motherboard motherboardWithCpu = new Motherboard("Asus ROG Maximus IX Formula", cpu);
		motherboardWithCpu = service.saveMotherboard(motherboardWithCpu);
		assertEquals(cpu, motherboardRepository.getOne(motherboardWithCpu.getId()).getCpu());
	}
	
	
	@Test
	public void addCpuToMotherboard() throws Exception {
		Motherboard motherboard = service.saveMotherboard(new Motherboard("Asus ROG Maximus IX Formula"));
		CPU cpu = service.saveCPU(new CPU("Intel Core i7-8700K Processor"));
		motherboard.setCpu(cpu);
		motherboard = service.saveMotherboard(motherboard);
		assertEquals(cpu, motherboardRepository.getOne(motherboard.getId()).getCpu());
	}
	
	
	@Test
	public void getAllMotherboardsByCpuModelName() throws Exception {
		CPU cpu1 = cpuRepository.save(new CPU("CPU_1"));
		CPU cpu2 = cpuRepository.save(new CPU("CPU_2"));
		Motherboard motherboardA = motherboardRepository.save(new Motherboard("MOBO_A", cpu1));
		Motherboard motherboardB = motherboardRepository.save(new Motherboard("MOBO_B", cpu1));
		Motherboard motherboardC = motherboardRepository.save(new Motherboard("MOBO_C", cpu2));
		Motherboard motherboardD = motherboardRepository.save(new Motherboard("MOBO_D", cpu2));
		assertEquals(Arrays.asList(motherboardA, motherboardB), service.getAllMotherboardsByCpuModelName("CPU_1"));
	}
	
}