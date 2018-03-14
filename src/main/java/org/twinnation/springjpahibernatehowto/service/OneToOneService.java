package org.twinnation.springjpahibernatehowto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.twinnation.springjpahibernatehowto.onetoone.model.CPU;
import org.twinnation.springjpahibernatehowto.onetoone.model.Motherboard;
import org.twinnation.springjpahibernatehowto.onetoone.repository.CPURepository;
import org.twinnation.springjpahibernatehowto.onetoone.repository.MotherboardRepository;

import java.util.List;


@Service
public class OneToOneService {
	
	@Autowired
	private CPURepository cpuRepository;
	
	@Autowired
	private MotherboardRepository motherboardRepository;
	
	
	public CPU saveCPU(CPU cpu) {
		return cpuRepository.save(cpu);
	}
	
	
	public Motherboard saveMotherboard(Motherboard motherboard) {
		return motherboardRepository.save(motherboard);
	}
	
	
	public List<Motherboard> getAllMotherboardsByCpuModelName(String cpuModelName) {
		return motherboardRepository.findAllByCpu_ModelName(cpuModelName);
	}
	
}
