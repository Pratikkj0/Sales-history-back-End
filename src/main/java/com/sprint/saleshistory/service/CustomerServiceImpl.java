package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CustomerRepository;
import com.sprint.saleshistory.entities.CustomerEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> updateCustomer(int id, CustomerEntity updatedCustomer) {
        Optional<CustomerEntity> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {
            CustomerEntity customerToUpdate = existingCustomer.get();
            // Update relevant fields of the existing customer with the data from updatedCustomer
            customerToUpdate.setFirstName(updatedCustomer.getFirstName());
            customerToUpdate.setLastName (updatedCustomer.getLastName());
            // ... other fields ...

            return Optional.of(customerRepository.save(customerToUpdate));
        } else {
            return Optional.empty(); // Customer with given id not found
        }
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerEntity> getCustomersByFirstName(String firstName) {
        return customerRepository.getCustomersByFirstName( firstName);
    }

    @Override
    public List<CustomerEntity> getCustomersByCity(String city) {
        return customerRepository.getCustomersByCity(city);
    }

  

    @Override
    public List<CustomerEntity> getCustomersByCreditLimitRange(Integer minCreditLimit, Integer maxCreditLimit) {
      //  return customerRepository.findByCreditLimitRange(minCreditLimit, maxCreditLimit);
    	return customerRepository.findByCreditLimitBetween(minCreditLimit, maxCreditLimit);
    }

	@Override
	public List<CustomerEntity> getCustomersByLastName(String LastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<CustomerEntity> getCustomersByIncome(String income) {
		return customerRepository.getCustomersByIncome(income);
	}
	

	
}

