package com.divyamotiwala.gradedproject4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divyamotiwala.gradedproject4.model.User;
import com.divyamotiwala.gradedproject4.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserRestController {

	private final UserService userService;
	
	@GetMapping
	public List<User> fetchAllUsers()
	{
		return this.userService.fetchAllUsers();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user)
	{
		return this.userService.saveUser(user);
	}
	
	
}
