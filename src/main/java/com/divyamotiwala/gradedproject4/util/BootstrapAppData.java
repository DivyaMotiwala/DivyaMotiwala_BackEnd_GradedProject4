package com.divyamotiwala.gradedproject4.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.divyamotiwala.gradedproject4.model.Employee;
import com.divyamotiwala.gradedproject4.model.Role;
import com.divyamotiwala.gradedproject4.model.User;
import com.divyamotiwala.gradedproject4.repository.EmployeeRepository;
import com.divyamotiwala.gradedproject4.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

private final EmployeeRepository employeeRepository;
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		Employee ramesh = new Employee();
		ramesh.setFirstName("Ramesh");
		ramesh.setLastName("Chandra");
		ramesh.setEmail("ramesh@gmail.com");
		this.employeeRepository.save(ramesh);
		
		Employee suresh = new Employee();
		suresh.setFirstName("Suresh");
		suresh.setLastName("Chandra");
		suresh.setEmail("suresh@gmail.com");

		this.employeeRepository.save(suresh);

		
		User vinay = new User();
		vinay.setUserName("vinay");
		vinay.setPassword(this.passwordEncoder.encode("welcome"));
		vinay.setEmailAddress("vinay@gmail.com");

		Role vinayRole = new Role();
		vinayRole.setRoleName("ADMIN");
		
		vinayRole.setUser(vinay);
		vinay.addRole(vinayRole);
		
		User rakesh = new User();
		rakesh.setUserName("rakesh");
		rakesh.setPassword(this.passwordEncoder.encode("welcome"));
		rakesh.setEmailAddress("rakesh@gmail.com");
		
		Role managerRole = new Role();
		managerRole.setRoleName("MANAGER");
		
		rakesh.addRole(managerRole);
		managerRole.setUser(rakesh);
		
		Role kiranRole = new Role();
		kiranRole.setRoleName("USER");
		
		User kiran = new User();
		kiran.setUserName("kiran");
		kiran.setPassword(this.passwordEncoder.encode("welcome"));
		kiran.setEmailAddress("kiran@gmail.com");
		kiran.addRole(kiranRole);
		kiranRole.setUser(kiran);		
		
		
		this.userRepository.save(kiran);
		this.userRepository.save(vinay);
		this.userRepository.save(rakesh);
		
		
	}

}
