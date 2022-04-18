package com.foreheed.ozedemo.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foreheed.ozedemo.persistence.entities.StaffMember;

public interface StaffMembersRepository extends JpaRepository<StaffMember, Integer> {
	
	int countByUuid(UUID uuid);

}
