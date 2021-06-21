package com.cognizant.orm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}