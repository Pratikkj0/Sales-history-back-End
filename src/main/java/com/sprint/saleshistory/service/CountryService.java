package com.sprint.saleshistory.service;

import java.util.List;

import com.sprint.saleshistory.dao.entities.Country;

public interface CountryService {
	
	List<Country> getAllCountries();
    Country getCountryById(Long countryId);
    Country saveCountry(Country country);
    void deleteCountry(Long countryId);

}
