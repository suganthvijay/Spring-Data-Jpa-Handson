package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

import com.cognizant.ormlearn.model.country;
import com.cognizant.ormlearn.CountryRepository;



@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repository;
	
	@Transactional
	public List<country> getAllCountries() {
		return repository.findAll();
	}

}