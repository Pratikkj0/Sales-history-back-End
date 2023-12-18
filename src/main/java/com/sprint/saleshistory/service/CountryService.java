package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sprint.saleshistory.entities.CountryEntity;
import com.sprint.saleshistory.models.CountryInfo;
import com.sprint.saleshistory.models.CountryPojo;


public interface CountryService {

	List<CountryEntity> getAllCountries();
	
	String addCountry(CountryEntity countryEntity);

	String updateCountry(int countryId, CountryEntity updatedCountryEntity);

	void deleteCountry(int countryId);

//	Long getCountByCountryName(String countryName);

	CountryInfo getCountAndCountriesByCountryName(String countryName);

	CountryInfo getCountAndCountriesByRegion(String region);
	
	Map<String, Long> getCountsForCountries(List<String> countryNames);

	Map<String, Long> getTotalCountByCountry();

	Map<String, Long> getTotalCountByRegion();

	Map<String, Long> getCountsForRegion(List<String> regionNames);



	
}
