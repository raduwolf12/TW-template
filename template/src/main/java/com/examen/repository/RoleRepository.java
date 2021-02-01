package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
