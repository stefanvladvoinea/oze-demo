package com.foreheed.ozedemo.rest.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PatientInformation {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private Date lastVisitDate;
	
}
