package com.cognizant.orm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.PayrolltableApplication;
import com.cognizant.orm.model.Employee_Skill;
import com.cognizant.orm.repository.Employee_SkillRepository;

@Service
public class Employee_SkillService {
  @Autowired
  private Employee_SkillRepository employeeRepository;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(PayrolltableApplication.class);
  
  @Transactional
  public Employee_Skill get(int id) {

	  LOGGER.info("Start");
	  return employeeRepository.findById(id).get();
  }
  
  @Transactional
  public void saveEmployee(Employee_Skill employee) {
	  LOGGER.info("Start");
	  employeeRepository.save(employee);
	  LOGGER.info("End");

  }
  
}