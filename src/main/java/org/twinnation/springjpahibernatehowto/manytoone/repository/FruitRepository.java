package org.twinnation.springjpahibernatehowto.manytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twinnation.springjpahibernatehowto.manytoone.model.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {}
