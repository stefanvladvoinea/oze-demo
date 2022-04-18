package com.foreheed.ozedemo.rest.mappers;

import org.mapstruct.Mapper;

import com.foreheed.ozedemo.persistence.entities.Patient;
import com.foreheed.ozedemo.rest.domain.PatientInformation;

@Mapper(componentModel = "spring")
public interface PatientMapper {

	PatientInformation fromPatientToPatientInformation(Patient patient);
	
}
