package com.divyamotiwala.gradedproject4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyamotiwala.gradedproject4.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
	
	 
}
