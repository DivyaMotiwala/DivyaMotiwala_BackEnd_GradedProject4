package com.divyamotiwala.gradedproject4.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divyamotiwala.gradedproject4.model.Employee;
import com.divyamotiwala.gradedproject4.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor

public class EmployeeRestController {

	private final EmployeeService employeeService;
	
	@GetMapping
	public Set<Employee> fetchAllEmployees()
	{
		return this.employeeService.fetchAllEmployees();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable ("id") Long id)
	{
		return this.employeeService.fetchEmployeeById(id);
	}
	
		
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable ("id") Long id, @RequestBody Employee employee)
	{
		return this.employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id)
	{
		this.employeeService.deleteEmployeeById(id);
		return "Deleted Employee id : " + id;
	}
	
	@GetMapping("/search/{fname}")
	public Set<Employee> fetchEmployeeByFirstName(@PathVariable ("fname") String fname)
	{
		return this.employeeService.fetchAllEmployeesByFirstName(fname);
	}
	
	@GetMapping("/sort")
	public List<Employee> sortEmployeeByFirstName(@RequestParam(value = "order") String order)
	{	
		return this.employeeService.fetchAllEmployeesSortedByFirstName(order);
		
	}
}
