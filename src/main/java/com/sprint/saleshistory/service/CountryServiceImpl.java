package com.sprint.saleshistory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CountryRepository;
import com.sprint.saleshistory.entities.CountryEntity;
import com.sprint.saleshistory.exception.CountryDeleteException;
import com.sprint.saleshistory.exception.CountryServiceException;
import com.sprint.saleshistory.exception.InvalidCountryNameException;
import com.sprint.saleshistory.exception.InvalidRegionNameException;
import com.sprint.saleshistory.models.CountryInfo;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<CountryEntity> getAllCountries() {
		try {
			if (null != countryRepository.findAll() && countryRepository.findAll().size() > 0) {
				return countryRepository.findAll();
			} else {
				throw new CountryServiceException("no countries found");
			}
		} catch (Exception ex) {
			throw new CountryServiceException("no countries found", ex);
		}
	}
	

	@Override
	public String addCountry(CountryEntity countryEntity) {
		// Basic validation
		if (countryEntity.getCountryName() == null || countryEntity.getCountryName().trim().isEmpty()) {
			throw new IllegalArgumentException("Country name cannot be empty");
		}

		try {
			countryRepository.save(countryEntity);
			return "Record Created Successfully";
		} catch (Exception ex) {
			throw new CountryServiceException("Error adding country", ex);
		}
	}

	@Override
	public String updateCountry(int countryId, CountryEntity updatedCountryEntity) {
		Optional<CountryEntity> existingCountryOptional = countryRepository.findById(countryId);

		if (existingCountryOptional.isPresent()) {
			CountryEntity existingCountry = existingCountryOptional.get();
			existingCountry.setCountryIsoCode(updatedCountryEntity.getCountryIsoCode());
			existingCountry.setCountryName(updatedCountryEntity.getCountryName());
			existingCountry.setCountrySubregion(updatedCountryEntity.getCountrySubregion());
			existingCountry.setCountrySubregionId(updatedCountryEntity.getCountrySubregionId());
			existingCountry.setCountryRegion(updatedCountryEntity.getCountryRegion());
			existingCountry.setCountryRegionId(updatedCountryEntity.getCountryRegionId());
			existingCountry.setCountryTotal(updatedCountryEntity.getCountryTotal());
			existingCountry.setCountryTotalId(updatedCountryEntity.getCountryTotalId());

			countryRepository.save(existingCountry);
			return "Record Updated Successfully";
		} else {
			throw new CountryServiceException("Country not found with ID: " + countryId);
		}
	}

	@Override
	public void deleteCountry(int countryId) {
		Optional<CountryEntity> countryToDelete = countryRepository.findById(countryId);

		if (countryToDelete.isPresent()) {
			CountryEntity country = countryToDelete.get();
			countryRepository.deleteById(countryId);
		} else {
			throw new CountryDeleteException("Country not found with ID: " + countryId);
		}
	}


	@Override
	public CountryInfo getCountAndCountriesByCountryName(String countryName) {
		if (countryName == null || countryName.trim().isEmpty()) {
			throw new InvalidCountryNameException("Country name cannot be empty or null");
		}
		List<CountryEntity> countries = countryRepository.findByCountryName(countryName);
		long count = countries.size();
		return new CountryInfo(count, countries);
	}

	@Override
	public CountryInfo getCountAndCountriesByRegion(String region) {
		if (region == null || region.trim().isEmpty()) {
			throw new InvalidRegionNameException("Region cannot be empty or null");
		}

		List<CountryEntity> countries = countryRepository.findByCountryRegion(region);
		long count = countries.size();

		return new CountryInfo(count, countries);
	}

	@Override
	public Map<String, Long> getCountsForCountries(List<String> countryNames) {
		Map<String, Long> counts = new HashMap<>();

		for (String countryName : countryNames) {
			if (countryName == null || countryName.trim().isEmpty()) {
				throw new InvalidCountryNameException("Country name cannot be empty or null");
			}

			Long count = countryRepository.countByCountryName(countryName);
			counts.put(countryName, count);
		}

		return counts;
	}

	@Override
	public Map<String, Long> getCountsForRegion(List<String> countryRegions) {
		Map<String, Long> counts = new HashMap<>();

		for (String regionName : countryRegions) {
			if (regionName == null || regionName.trim().isEmpty()) {
				throw new InvalidRegionNameException("Region name cannot be empty or null");
			}

			Long count = countryRepository.countByCountryRegion(regionName);
			counts.put(regionName, count);
		}

		return counts;
	}
	

	@Override
	public Map<String, Long> getTotalCountByCountry() {
		List<CountryEntity> allCountries = countryRepository.findAll();

		Map<String, Long> totalCountByCountry = new HashMap<>();
		for (CountryEntity country : allCountries) {
			String countryName = country.getCountryName();
			totalCountByCountry.put(countryName, totalCountByCountry.getOrDefault(countryName, 0L) + 1);
		}

		return totalCountByCountry;
	}

	@Override
	public Map<String, Long> getTotalCountByRegion() {
		List<CountryEntity> allCountries = countryRepository.findAll();

		Map<String, Long> totalCountByRegion = new HashMap<>();
		for (CountryEntity country : allCountries) {
			String regionName = country.getCountryRegion();
			totalCountByRegion.put(regionName, totalCountByRegion.getOrDefault(regionName, 0L) + 1);
		}

		return totalCountByRegion;
	}

}
