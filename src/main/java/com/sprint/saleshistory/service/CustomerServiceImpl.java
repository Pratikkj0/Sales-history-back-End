package com.sprint.saleshistory.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CustomerRepository;
import com.sprint.saleshistory.dao.entities.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    CustomerRepository customerRepository;
	

    
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



	@Override
	public List<Customer> getAllCustomers() {

		
		
		return null;
		
		
		
//		public List<ProductPojo> getAllProducts() {
//			List<ProductEntity> allProductsEntity = productRepository.findAll();
//			List<ProductPojo> allProductPojo = new ArrayList<ProductPojo>();
//			for (ProductEntity productEntity : allProductsEntity) {
//				ProductPojo productPojo = new ProductPojo();
//				BeanUtils.copyProperties(productEntity, productPojo);
//				allProductPojo.add(productPojo);
			}
	



	@Override
	public Optional<Customer> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<Customer> updateCustomer(Long id, Customer updatedCustomer) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
	}
    
    }
