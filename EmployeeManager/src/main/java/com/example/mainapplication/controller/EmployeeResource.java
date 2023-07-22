package com.example.mainapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mainapplication.model.Employee;
import com.example.mainapplication.services.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")

public class EmployeeResource {
	
	private final EmployeeService employeeservice;
	
	public EmployeeResource(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	@GetMapping("/all")
	public  List<Employee> getAllEmployees (){
		return employeeservice.FindAllEmployees();
	  }
	
	@GetMapping("/find/{id}")
	  public ResponseEntity<Optional<Employee>> getEmployeeById (@PathVariable("id") Long id){
		Optional<Employee> employee = employeeservice.findEmployeebyId(id);
		return new ResponseEntity<>(employee , HttpStatus.OK);
	  }
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee){
		Employee newEmployee = employeeservice.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee){
		Employee updateEmployee = employeeservice.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee (@PathVariable("id") Long id){
	    employeeservice.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}