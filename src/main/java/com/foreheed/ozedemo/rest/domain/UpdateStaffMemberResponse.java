package com.foreheed.ozedemo.rest.domain;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class UpdateStaffMemberResponse {
	
	private Integer id;
	
	private UUID uuid;

	private String name;
	
	private Date registrationDate;
	
}
