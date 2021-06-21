package com.cognizant.orm.service;

public class CountryNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String message) {
		super(message);
	}
}
