package com.cognizant.orm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.PayrolltableApplication;

import com.cognizant.orm.model.Skill;
import com.cognizant.orm.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayrolltableApplication.class);
	
	@Transactional
	public Skill get(int id) {

		  LOGGER.info("Start");
		  return skillRepository.findById(id).get();
	  }
	  
	  @Transactional
	  public void save(Skill skill) {
		  LOGGER.info("Start");
		  skillRepository.save(skill);
		  LOGGER.info("End");

	  }
}