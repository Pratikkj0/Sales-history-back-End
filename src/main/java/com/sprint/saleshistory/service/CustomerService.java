  package com.sprint.saleshistory.service;

import java.util.List;


import com.sprint.saleshistory.models.CustomerPojo;

public interface CustomerService {

	List<CustomerPojo> getAllCustomers();

	String createCustomer(CustomerPojo customer);

	List<CustomerPojo> getCustomersByFirstName(String firstName);

	List<CustomerPojo> getCustomersByCity(String city);

	List<CustomerPojo> getCustomersByIncome(String income);

	List<CustomerPojo> getCustomersByCreditLimit(Integer CreditLimit);

	public String deleteCustomer(long id);

	public String updateCustomer(long id, CustomerPojo customer);

	void updateCreditLimit(int customerId, int newCreditLimit);
	

}
