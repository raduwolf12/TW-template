package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.model.ScorEvaluare;

@Repository
public interface ScorEvaluareRepository extends JpaRepository<ScorEvaluare, Long> {
	
}
