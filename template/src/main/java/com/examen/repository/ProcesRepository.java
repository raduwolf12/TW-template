package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.model.Proces;

@Repository
public interface ProcesRepository extends JpaRepository<Proces, Long> {

}
