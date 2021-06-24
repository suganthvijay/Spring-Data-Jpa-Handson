package com.cognizant.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
	
	List<Country> findByNameContaining(String str);
	
	List<Country> findByNameContainingOrderByNameAsc(String str);
	
	List<Country> findByNameStartingWith(String s);
}