package com.foreheed.ozedemo.persistence.entities;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient extends IdableEntity {

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "last_visit_date", nullable = false)
	private ZonedDateTime lastVisitDate;
	
}
