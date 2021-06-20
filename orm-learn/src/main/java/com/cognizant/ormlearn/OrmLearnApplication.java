package com.cognizant.ormlearn;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.country;
import com.cognizant.ormlearn.service.CountryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static CountryService countryService;
	private static BeanFactory context;
	
	 private static void testCountries() {

		 LOGGER.info("started");

		 List<country> countries = countryService.getAllCountries();

		 LOGGER.debug("countries", countries);

		 LOGGER.info("End");

		 }
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testCountries(); 
		
	}

}
