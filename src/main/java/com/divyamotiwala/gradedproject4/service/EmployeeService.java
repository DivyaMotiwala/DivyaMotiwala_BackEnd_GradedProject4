package com.divyamotiwala.gradedproject4.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.divyamotiwala.gradedproject4.model.Employee;
import com.divyamotiwala.gradedproject4.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee)
	{
		return this.employeeRepository.save(employee);
	}
	
	public Set<Employee> fetchAllEmployees()
	{
		return new HashSet<>(this.employeeRepository.findAll());
	}
	
	public Employee fetchEmployeeById(Long id)
	{
		return this.employeeRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id passed"));
	}
	
	public Employee updateEmployee(Long id, Employee employee)
	{
		Employee savedEmployee = fetchEmployeeById(id);
		savedEmployee.setFirstName(employee.getFirstName());
		savedEmployee.setLastName(employee.getLastName());
		savedEmployee.setEmail(employee.getEmail());
		this.employeeRepository.save(savedEmployee);
		return savedEmployee;
	}
	
	public void deleteEmployeeById(Long id)
	{
		this.employeeRepository.deleteById(id);
	}
	
	public Set<Employee> fetchAllEmployeesByFirstName(String fname)
	{
		return new HashSet<>(this.employeeRepository.findByFirstName(fname));
	}
	
	
	public List<Employee> fetchAllEmployeesSortedByFirstName(String order)
	{
		List<Employee> sortedEmpList = new ArrayList<Employee>();
		if(order.matches("desc"))
			sortedEmpList = new ArrayList<> (this.employeeRepository.findAll(Sort.by("firstName").descending()));
		else if(order.matches("asc"))
			sortedEmpList = new ArrayList<> (this.employeeRepository.findAll(Sort.by("firstName").ascending()));
		return sortedEmpList;
	}
}
