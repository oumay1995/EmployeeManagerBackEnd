package com.example.mainapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mainapplication.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	/* Optional<Employee>findEmployeebyId(Long id);*/
}