package com.cognizant.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm.model.Department;
import com.cognizant.orm.model.Employee_Skill;
import com.cognizant.orm.model.Skill;
import com.cognizant.orm.service.DepartmentService;
import com.cognizant.orm.service.Employee_SkillService;
import com.cognizant.orm.service.SkillService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PayrolltableApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(PayrolltableApplication.class);
	public static Employee_SkillService employeeService;
	public static DepartmentService departmentService;
	public static SkillService skillService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(PayrolltableApplication.class, args);
		employeeService = context.getBean(Employee_SkillService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		
		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
		LOGGER.info("Inside main");
	}
	
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee_Skill employee = employeeService.get(101);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");

		}
	
	private static void testAddEmployee() {
		
		Employee_Skill employee = new Employee_Skill();
		employee.setId(105);
		employee.setName("Neelima");
		employee.setSalary(25000.00);
		try {
			employee.setDateOfBirth(new SimpleDateFormat("YYYY-MM-DD").parse("1999-04-28"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.setPermanent(true);
		
		Department dept= departmentService.get(1);
		employee.setDepartment(dept);
		employeeService.saveEmployee(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");

		Employee_Skill employee = employeeService.get(105);
		Department dept= departmentService.get(3);
		employee.setDepartment(dept);
		employeeService.saveEmployee(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());

		LOGGER.info("End");
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");

		 Department dept= departmentService.get(1);

		LOGGER.debug("Department:{}", dept);

		LOGGER.debug("Department:{}", dept.getEmployeeList());

		LOGGER.info("End");

	}
	
	private static void testAddSkillToEmployee() {
		
		Employee_Skill employee = employeeService.get(101);
		Skill skill = skillService.get(13);
		
		Set<Skill> set=employee.getSkillList();
		set.add(skill);
		
		employee.setSkillList(set);
		
		employeeService.saveEmployee(employee);
	}
}