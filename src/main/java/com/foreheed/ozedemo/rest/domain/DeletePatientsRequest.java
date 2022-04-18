package com.foreheed.ozedemo.rest.domain;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class DeletePatientsRequest {

	private ZonedDateTime after;
	
	private ZonedDateTime before;
	
}
