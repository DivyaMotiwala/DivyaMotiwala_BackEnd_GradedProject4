package com.divyamotiwala.gradedproject4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.divyamotiwala.gradedproject4.model.Role;
import com.divyamotiwala.gradedproject4.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RoleService {

	private final RoleRepository roleRepository;
	
	public Role saveRole(Role role)
	{
		return this.roleRepository.save(role);
	}
	
	public List<Role> fetchAllRoles()
	{
		return new ArrayList<>(this.roleRepository.findAll());
	}
	
	
}
