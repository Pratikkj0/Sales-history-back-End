package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.entities.CountryEntity;
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    // You can add custom query methods if needed {

}
