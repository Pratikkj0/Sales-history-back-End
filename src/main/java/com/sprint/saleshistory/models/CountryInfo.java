package com.sprint.saleshistory.models;

import java.util.List;

import com.sprint.saleshistory.entities.CountryEntity;

public class CountryInfo {

    private final long count;
    private final List<CountryEntity> countries;

    public CountryInfo(long count, List<CountryEntity> countries) {
        this.count = count;
        this.countries = countries;
    }

    public long getCount() {
        return count;
    }

    public List<CountryEntity> getCountries() {
        return countries;
    }
}
