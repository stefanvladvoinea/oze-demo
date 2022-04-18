package com.foreheed.ozedemo.rest.domain;

import java.util.List;

import lombok.Data;

@Data
public class GetAllPatientsResponse {
	
	private List<PatientInformation> patients;
	
}
