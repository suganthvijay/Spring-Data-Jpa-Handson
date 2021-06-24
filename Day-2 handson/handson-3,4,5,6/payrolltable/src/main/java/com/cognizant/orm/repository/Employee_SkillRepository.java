package com.cognizant.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cognizant.orm.model.Employee_Skill;

@Repository
public interface Employee_SkillRepository  extends JpaRepository<Employee_Skill, Integer>{

}