package com.cognizant.ormtool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import hibernate.Employee;
@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}