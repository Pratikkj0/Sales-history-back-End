package com.sprint.saleshistory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint.saleshistory.entities.CustomerEntity;
import com.sprint.saleshistory.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable int id) {
        Optional<CustomerEntity> customer = customerService.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable int id, @RequestBody CustomerEntity updatedCustomer) {
        Optional<CustomerEntity> customer = customerService.updateCustomer(id, updatedCustomer);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/firstname/{firstName}")
    public List<CustomerEntity> getCustomersByFirstName(@PathVariable String firstName) {
        return customerService.getCustomersByFirstName(firstName);
    }

    @GetMapping("/city/{city}")
    public List<CustomerEntity> getCustomersByCity(@PathVariable String city) {
        return customerService.getCustomersByCity(city);
    }

    @GetMapping("/income/{income}")
    public List<CustomerEntity> getCustomersByIncome(@PathVariable String income) {
        return customerService.getCustomersByIncome(income);
    }

    @GetMapping("/limit/{minCreditLimit}/{maxCreditLimit}")
    public List<CustomerEntity> getCustomersByCreditLimitRange(@PathVariable Integer minCreditLimit,
                                                         @PathVariable Integer maxCreditLimit) {
        return customerService.getCustomersByCreditLimitRange(minCreditLimit, maxCreditLimit);
    }
}


