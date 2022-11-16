package com.divyamotiwala.gradedproject4.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.divyamotiwala.gradedproject4.model.Employee;
import com.divyamotiwala.gradedproject4.model.Role;
import com.divyamotiwala.gradedproject4.model.User;
import com.divyamotiwala.gradedproject4.repository.EmployeeRepository;
import com.divyamotiwala.gradedproject4.repository.RoleRepository;
import com.divyamotiwala.gradedproject4.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

private final EmployeeRepository employeeRepository;
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	
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

		Role vinayRole = new Role();
		vinayRole.setRoleName("ADMIN");
		
		Role managerRole = new Role();
		managerRole.setRoleName("MANAGER");
		
		Role kiranRole = new Role();
		kiranRole.setRoleName("USER");
		
		this.roleRepository.save(vinayRole);
		this.roleRepository.save(managerRole);
		this.roleRepository.save(kiranRole);
		
		User vinay = new User();
		vinay.setUserName("vinay");
		vinay.setPassword(this.passwordEncoder.encode("admin"));
		vinay.setEmailAddress("vinay@gmail.com");
		vinay.addRole(vinayRole);
		
		User rakesh = new User();
		rakesh.setUserName("rakesh");
		rakesh.setPassword(this.passwordEncoder.encode("welcome"));
		rakesh.setEmailAddress("rakesh@gmail.com");
		rakesh.addRole(managerRole);
		
		
		User kiran = new User();
		kiran.setUserName("kiran");
		kiran.setPassword(this.passwordEncoder.encode("welcome"));
		kiran.setEmailAddress("kiran@gmail.com");
		kiran.addRole(kiranRole);
		
		this.userRepository.save(kiran);
		this.userRepository.save(vinay);
		this.userRepository.save(rakesh);
		
		
	}

}
