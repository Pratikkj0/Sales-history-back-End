package com.sprint.saleshistory.service;

import java.util.List;

import com.sprint.saleshistory.entities.CountryEntity;

public interface CountryService {
	
	List<CountryEntity> getAllCountries();
    CountryEntity getCountryById(Long countryId);
    CountryEntity saveCountry(CountryEntity country);
    void deleteCountry(Long countryId);

}
