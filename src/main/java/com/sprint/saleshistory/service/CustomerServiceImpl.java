package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CustomerRepository;
import com.sprint.saleshistory.entities.CustomerEntity;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.CustomerPojo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerPojo> getAllCustomers() {
		List<CustomerEntity> allCustomerEntity = customerRepository.findAll();
		if (allCustomerEntity.isEmpty()) {
			throw new RecordNotFoundException("CUSTOMER NOT FOUND");

		}
		List<CustomerPojo> allCustomerPojo = new ArrayList<>();

		for (CustomerEntity customerEntity : allCustomerEntity) {

			CustomerPojo customerPojo = new CustomerPojo();

			BeanUtils.copyProperties(customerEntity, customerPojo);

			allCustomerPojo.add(customerPojo);
		}

		return allCustomerPojo;
	}

//	 add
	public String createCustomer(CustomerPojo customer) {
		List<CustomerEntity> lst = customerRepository.getCustomersByFirstName(customer.getFirstName());

		if (!lst.isEmpty()) {
			throw new DuplicateRecordException("Customer with the same name already exists.");
		}
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, customerEntity);
		customerRepository.save(customerEntity);

		return "Record Created Successfully";
	}

	@Override
	public String deleteCustomer(long id) {
		Optional<CustomerEntity> del = customerRepository.findById((int) id);
		if (del.isPresent()) {
			customerRepository.deleteById((int) id);
			return "Record deleted Successfully";
		} else
			throw new RuntimeException("Record is Not Present To Delete");

	}

	@Override
	public List<CustomerPojo> getCustomersByFirstName(String firstName) {
		List<CustomerEntity> allCustomerEntity = customerRepository.getCustomersByFirstName(firstName);
		if (allCustomerEntity.isEmpty()) {

			throw new RecordNotFoundException("CUSTOMER NOT FOUND");
		}
		List<CustomerPojo> allCustomerPojo = new ArrayList<>(); // pojo ka array list
		for (CustomerEntity customerEntity : allCustomerEntity) { // iss list ko terarte kar diye
			CustomerPojo customerPojo = new CustomerPojo();

			BeanUtils.copyProperties(customerEntity, customerPojo);

			allCustomerPojo.add(customerPojo);

		}

		return allCustomerPojo;

	}

	@Override
	public List<CustomerPojo> getCustomersByCity(String city) {
		List<CustomerEntity> allCustomerEntity = customerRepository.getCustomersByCity(city);// yaha pe repository se
		if (allCustomerEntity.isEmpty()) {
			throw new RecordNotFoundException("CUSTOMER NOT FOUND");
		} // data entity me daal
		// diye
		List<CustomerPojo> allCustomerPojo = new ArrayList<>();      // Pojo ka array list banaye hai
		for (CustomerEntity customerEntity : allCustomerEntity) {

			CustomerPojo customerPojo = new CustomerPojo();        // customer pojo ka object

			BeanUtils.copyProperties(customerEntity, customerPojo);
			allCustomerPojo.add(customerPojo);
		}
		return allCustomerPojo;
	}

	@Override

	public List<CustomerPojo> getCustomersByIncome(String income) {

		List<CustomerEntity> allCustomerEntity = customerRepository.getCustomersByIncome(income);
		if (allCustomerEntity.isEmpty()) {
			throw new RecordNotFoundException("CUSTOMER NOT FOUND");
		}
		List<CustomerPojo> allCustomerPojo = new ArrayList<>();
		for (CustomerEntity customerEntity : allCustomerEntity) { // allCustomerEntity wala list ko ieterate kara diye
																	// aur uska data ko customerEntity me daal diye
			CustomerPojo customerPojo = new CustomerPojo();// customer pojo ka object
			BeanUtils.copyProperties(customerEntity, customerPojo);
			allCustomerPojo.add(customerPojo);
		}
		return allCustomerPojo;
	}

	@Override
	public List<CustomerPojo> getCustomersByCreditLimit(Integer CreditLimit) {

		List<CustomerEntity> allCustomerEntity = customerRepository.findByCreditLimit(CreditLimit);
		if (allCustomerEntity.isEmpty()) {
			throw new RecordNotFoundException("CUSTOMER NOT FOUND");
		}
		List<CustomerPojo> allCustomerPojo = new ArrayList<>();
		for (CustomerEntity customerEntity : allCustomerEntity) { // allCustomerEntity wala list ko ieterate kara diye

			CustomerPojo customerPojo = new CustomerPojo();// customer pojo ka object
			BeanUtils.copyProperties(customerEntity, customerPojo);
			allCustomerPojo.add(customerPojo);// 1-1 karke data list me add kar diye
		}
		return allCustomerPojo;

	}

	@Override
	public String updateCustomer(long id, CustomerPojo customerPojo) {

		CustomerEntity customer = new CustomerEntity();
		BeanUtils.copyProperties(customerPojo, customer);
		Optional<CustomerEntity> ceo = customerRepository.findById((int) id);
		if (ceo.isEmpty()) {
			throw new RecordNotFoundException("CUSTOMER NOT FOUND");
		}
		CustomerEntity ce = ceo.get();
		ce = customer;
		customerRepository.save(ce);
		return "Record Updated Succesfully";
	}

	@Override
	public void updateCreditLimit(int customerId, int newCreditLimit) {
		CustomerEntity customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
		customer.setCreditLimit(newCreditLimit);
		customerRepository.save(customer);
	}

}
