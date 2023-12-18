package com.sprint.saleshistory.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint.saleshistory.models.CustomerPojo;
import com.sprint.saleshistory.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<CustomerPojo> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@PostMapping
	public String createCustomer(@RequestBody CustomerPojo customer) {
		this.customerService.createCustomer(customer);
		return "Record Created Successfully";
	}

	@PutMapping("/update")
	public String updateCustomer(long id, CustomerPojo customer) {

		customerService.updateCustomer(id, customer);
		return "Record Updated Succesfully";

	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return "Record deleted Successfully";
	}

	@GetMapping("/{firstName}")
	public List<CustomerPojo> getCustomersByFirstName(@PathVariable("firstName") String firstName) {
		return customerService.getCustomersByFirstName(firstName);
	}

	@GetMapping("/city/{city}")
	public List<CustomerPojo> getCustomersByCity(@PathVariable String city) {
		return customerService.getCustomersByCity(city);
	}

	@GetMapping("/income/{income}")
	public List<CustomerPojo> getCustomersByIncome(@PathVariable String income) {
		return customerService.getCustomersByIncome(income);
	}

	@GetMapping("/limit/{CreditLimit}")
	public List<CustomerPojo> getCustomersByCreditLimit(@PathVariable Integer CreditLimit) {
		return customerService.getCustomersByCreditLimit(CreditLimit);
	}

	@PutMapping("cd/{id}/{CreditLimit}")
	public ResponseEntity<String> updateCreditLimit(@PathVariable("id") int id,
			@PathVariable("CreditLimit") int CreditLimit) {
		customerService.updateCreditLimit(id, CreditLimit);
		return ResponseEntity.ok("Record updated Successfully");
	}
	
}


 
