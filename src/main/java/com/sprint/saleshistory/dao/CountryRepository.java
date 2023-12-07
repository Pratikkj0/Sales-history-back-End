package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.saleshistory.dao.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    // You can add custom query methods if needed {

}
