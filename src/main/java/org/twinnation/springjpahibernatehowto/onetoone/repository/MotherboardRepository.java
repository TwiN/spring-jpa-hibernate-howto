package org.twinnation.springjpahibernatehowto.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twinnation.springjpahibernatehowto.onetoone.model.Motherboard;

import java.util.List;


@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
	
	List<Motherboard> findAllByCpu_ModelName(String cpuModelName);
	
}
