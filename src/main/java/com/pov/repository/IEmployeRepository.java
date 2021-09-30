package com.pov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pov.entities.Employe;

@Repository
public interface IEmployeRepository extends JpaRepository<Employe, Long> {

	public Employe findByLogin(String login);
	
}
