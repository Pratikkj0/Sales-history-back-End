package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Optional;

import com.sprint.saleshistory.entities.CustomerEntity;

public interface CustomerService {

	 List<CustomerEntity> getAllCustomers();
	    Optional<CustomerEntity> getCustomerById(int id);
	    CustomerEntity createCustomer(CustomerEntity customer);
	    Optional<CustomerEntity> updateCustomer(int id, CustomerEntity updatedCustomer);

	    void deleteCustomer(Long id);
	    List<CustomerEntity> getCustomersByFirstName(String firstName);
	    List<CustomerEntity> getCustomersByLastName(String lastName);
	    List<CustomerEntity> getCustomersByCity(String city);
	    List<CustomerEntity> getCustomersByIncome(String income);
	    List<CustomerEntity> getCustomersByCreditLimitRange(Integer minCreditLimit, Integer maxCreditLimit);
	    void deleteCustomer(int id);
}



