package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@SpringBootApplication
public class StocktableApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(StocktableApplication.class);
	private static StockService stockService;
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StocktableApplication.class, args);
		LOGGER.info("Inside main"); 
		stockService = context.getBean(StockService.class);
		List<Stock> list=stockService.getTop3ByCode();
		for(Stock s: list) {
			System.out.println(s.toString());
		}
	}

}
