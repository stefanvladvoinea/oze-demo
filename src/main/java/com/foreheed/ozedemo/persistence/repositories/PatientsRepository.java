package com.foreheed.ozedemo.persistence.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreheed.ozedemo.persistence.entities.Patient;

public interface PatientsRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findByLastVisitDateAfter(ZonedDateTime after);
	
	void removeByLastVisitDateBetween(ZonedDateTime before, ZonedDateTime after);
}
