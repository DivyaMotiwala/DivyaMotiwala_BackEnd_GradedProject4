package com.divyamotiwala.gradedproject4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.divyamotiwala.gradedproject4.model.DomainUserDetails;
import com.divyamotiwala.gradedproject4.model.User;
import com.divyamotiwala.gradedproject4.repository.UserRepository;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = this.userRepository.findByUserName(username)
						.orElseThrow(() -> new UsernameNotFoundException(username));
		System.out.println("User from Repository : " + user);
		return new DomainUserDetails(user);
	}

}
