package org.twinnation.springjpahibernatehowto.manytoone.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.twinnation.springjpahibernatehowto.manytoone.model.Bowl;


@Repository
public interface BowlRepository extends JpaRepository<Bowl, Long> {}
