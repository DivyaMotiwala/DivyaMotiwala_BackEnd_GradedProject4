package com.divyamotiwala.gradedproject4.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.divyamotiwala.gradedproject4.model.User;
import com.divyamotiwala.gradedproject4.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserService {

	private final UserRepository userRepository;
	
	public User saveUser(User user)
	{
		return this.userRepository.save(user);
	}
	
	public List<User> fetchAllUsers()
	{
		return new ArrayList<>(this.userRepository.findAll());
	}
	
	public List<User> sortAllUsersByUserName(Direction direction)
	{
		if(direction.isAscending())
			return new ArrayList<>(this.userRepository.findAllByOrderByUserNameAsc());
		else
			return new ArrayList<>(this.userRepository.findAllByOrderByUserNameDesc());
	}
	

}
