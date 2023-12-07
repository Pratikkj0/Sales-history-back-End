package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Optional;

import com.sprint.saleshistory.dao.entities.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Optional<Customer> updateCustomer(Long id, Customer updatedCustomer);

    void deleteCustomer(Long id);
}
