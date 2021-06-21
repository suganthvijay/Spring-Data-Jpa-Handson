package com.cognizant.orm;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm.model.Country;
import com.cognizant.orm.service.CountryService;
import com.cognizant.orm.service.CountryNotFoundException;

@SpringBootApplication
public class OrmApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmApplication.class);
	private static CountryService countryService;
	public static void main(String[] args) {
		SpringApplication.run(OrmApplication.class, args);
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		try {
			getAllCountriesTest();
			testAddCountry();
			testUpdateCountry();
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testDeleteCountry();
	}
	private static void testGetAllCountries() {

		LOGGER.info("Starting testGetAllCountries ");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}
	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Starting getAllCountriesTest");

		Country country = countryService.findCountryByCode("AF");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}
	private static void testAddCountry() throws CountryNotFoundException {

		LOGGER.info("Starting testAddCountry");
		Country demoCountry = new Country();
		demoCountry.setCode("ZZ");
		demoCountry.setName("DEMO");
		countryService.addCountry(demoCountry);
		Country country = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}
	private static void testUpdateCountry() throws CountryNotFoundException {

		LOGGER.info("Starting testUpdateCountry");
		countryService.updateCountry("ZZ", "ZIMWAMBE");
		Country country = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}
	private static void testDeleteCountry() {

		LOGGER.info("Starting testDeleteCountry");
		countryService.deleteCountry("ZZ");
		LOGGER.info("End");

	}

}
