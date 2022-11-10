package com.divyamotiwala.gradedproject4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divyamotiwala.gradedproject4.model.Role;
import com.divyamotiwala.gradedproject4.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor

public class RoleRestController {

	private final RoleService roleService;
	
	@GetMapping
	public List<Role> fetchAllRoles()
	{
		return this.roleService.fetchAllRoles();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Role saveEmployee(@RequestBody Role role)
	{
		return this.roleService.saveRole(role);
	}
	
}
