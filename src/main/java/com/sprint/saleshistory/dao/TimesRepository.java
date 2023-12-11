package com.sprint.saleshistory.dao;

import com.sprint.saleshistory.entities.TimesEntity;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesRepository extends JpaRepository<TimesEntity, Date> {
}
