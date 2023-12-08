package com.sprint.saleshistory.service;

import com.sprint.saleshistory.entities.CountryEntity;

import com.sprint.saleshistory.dao.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public CountryEntity getCountryById(Long countryId) {
        Optional<CountryEntity> optionalCountry = countryRepository.findById(countryId);
        return optionalCountry.orElse(null);
    }

    @Override
    public CountryEntity saveCountry(CountryEntity country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}



