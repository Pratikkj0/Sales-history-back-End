package com.sprint.saleshistory.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.saleshistory.entities.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{

	Long countByCountryName(String countryName);

	List<CountryEntity> findByCountryName(String countryName);

	List<CountryEntity> findByCountryRegion(String region);

	Long countByCountryRegion(String countryRegion);

}
