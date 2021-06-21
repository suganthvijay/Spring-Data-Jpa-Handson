package com.cognizant.ormtool.Service;

import javax.transaction.Transactional;
com.cognizant.ormtool.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import hibernate.Employee;
@Autowired
private EmployeeRepository employeeRepository;

@Transactional

public void addEmployee(Employee employee) {

employeeRepository.save(employee);

}