package org.twinnation.springjpahibernatehowto.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twinnation.springjpahibernatehowto.onetoone.model.CPU;


@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {}
