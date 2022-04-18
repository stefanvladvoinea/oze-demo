package com.foreheed.ozedemo.persistence.entities;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "staff_members")
public class StaffMember extends IdableEntity {

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "uuid", nullable = false)
	private UUID uuid;
	
	@Column(name = "registration_date")
	private ZonedDateTime registrationDate;
	
}
