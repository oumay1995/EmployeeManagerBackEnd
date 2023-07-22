package com.example.mainapplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mainapplication.model.Employee;
import com.example.mainapplication.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepository employeerepo;
	@Autowired
	public EmployeeService(EmployeeRepository employeerepo) {
		this.employeerepo = employeerepo;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeerepo.save(employee);
	}
	public List<Employee> FindAllEmployees(){
		return employeerepo.findAll();
	}
	public Employee updateEmployee(Employee employee) {
		return employeerepo.save(employee);
	}
	public void deleteEmployee (Long id) {
		employeerepo.deleteById(id);
	}
	
	public Optional<Employee> findEmployeebyId(Long id) {
			return  employeerepo.findById(id);
		}

}
