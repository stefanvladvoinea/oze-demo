package com.foreheed.ozedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foreheed.ozedemo.persistence.repositories.PatientsRepository;
import com.foreheed.ozedemo.persistence.repositories.StaffMembersRepository;

@Configuration
public class ServicesConfig {

	@Bean
	public StaffMembersService staffMembersService(@Autowired StaffMembersRepository staffMembersRepository) {
		return new StaffMembersService(staffMembersRepository);
	}
	
	@Bean
	public PatientsService patientsService(@Autowired PatientsRepository patientsRepository) {
		return new PatientsService(patientsRepository);
	}
	
}
