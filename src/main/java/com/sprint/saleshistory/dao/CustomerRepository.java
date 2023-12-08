package com.sprint.saleshistory.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	
	    List<CustomerEntity> getCustomersByFirstName(String firstName);
	    List<CustomerEntity> getCustomersByLastName(String LastName);
	    List<CustomerEntity> getCustomersByCity(String city);
        List<CustomerEntity> getCustomersByIncome(String income);
        //List<CustomerEntity> findByCreditLimitRange(Integer minCreditLimit, Integer maxCreditLimit);
	    List<CustomerEntity> findByCreditLimitBetween(Integer minCreditLimit, Integer maxCreditLimit);
	
}

	
	

