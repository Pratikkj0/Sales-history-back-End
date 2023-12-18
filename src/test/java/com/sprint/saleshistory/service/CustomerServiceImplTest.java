package com.sprint.saleshistory.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.saleshistory.dao.CustomerRepository;
import com.sprint.saleshistory.entities.CustomerEntity;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.CustomerPojo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

 

    @Test
    void testGetAllCustomers() {
        // Mocking the repository behavior
        List<CustomerEntity> mockCustomerEntities = new ArrayList<>();
        mockCustomerEntities.add(createMockCustomerEntity());

        when(customerRepository.findAll()).thenReturn(mockCustomerEntities);

        // Calling the service method
        List<CustomerPojo> result = customerService.getAllCustomers();

        // Assertions
        assertFalse(result.isEmpty());
        assertEquals(mockCustomerEntities.size(), result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetAllCustomersNoResults() {
        // Mocking the repository behavior when no customers are found
        when(customerRepository.findAll()).thenReturn(new ArrayList<>());

        // Assertions
        assertThrows(RecordNotFoundException.class, () -> customerService.getAllCustomers());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testDeleteCustomer() {
        // Mocking the repository behavior
        long customerId = 1L;
        Optional<CustomerEntity> customerEntityOptional = Optional.of(createMockCustomerEntity(customerId));
        when(customerRepository.findById(eq((int) customerId))).thenReturn(customerEntityOptional);

        // Calling the service method
        String result = customerService.deleteCustomer(customerId);

        // Assertions
        assertEquals("Record deleted Successfully", result);

        // Verify that the repository's findById and deleteById methods were called
        verify(customerRepository, times(1)).findById(eq((int) customerId));
        verify(customerRepository, times(1)).deleteById(eq((int) customerId));
    }

    @Test
    void testDeleteCustomerNotFound() {
        // Mocking the repository behavior when customer is not found
        long customerId = 1L;
        when(customerRepository.findById(eq((int) customerId))).thenReturn(Optional.empty());

        // Assertions
        assertThrows(RuntimeException.class, () -> customerService.deleteCustomer(customerId));

        // Verify that the repository's findById method was called, but deleteById was not called
        verify(customerRepository, times(1)).findById(eq((int) customerId));
        verify(customerRepository, never()).deleteById(anyInt());
    }

    // Helper method to create a mock CustomerEntity
    private CustomerEntity createMockCustomerEntity(long customerId) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerId);
        // Set other properties as needed
        return customerEntity;
    }
    
    @Test
    void testUpdateCreditLimit() {
        // Mocking the repository behavior
        int customerId = 1;
        int newCreditLimit = 5000;
        CustomerEntity customerEntity = createMockCustomerEntity(customerId);
        when(customerRepository.findById(eq(customerId))).thenReturn(Optional.of(customerEntity));

        // Calling the service method
        customerService.updateCreditLimit(customerId, newCreditLimit);

        // Assertions
        assertEquals(newCreditLimit, customerEntity.getCreditLimit());

        // Verify that the repository's findById and save methods were called
        verify(customerRepository, times(1)).findById(eq(customerId));
        verify(customerRepository, times(1)).save(eq(customerEntity));
    }

    @Test
    void testUpdateCreditLimitNotFound() {
        // Mocking the repository behavior when customer is not found
        int customerId = 1;
        int newCreditLimit = 5000;
        when(customerRepository.findById(eq(customerId))).thenReturn(Optional.empty());

        // Assertions
        assertThrows(RuntimeException.class, () -> customerService.updateCreditLimit(customerId, newCreditLimit));

        // Verify that the repository's findById method was called, but save was not called
        verify(customerRepository, times(1)).findById(eq(customerId));
        verify(customerRepository, never()).save(any());
    }

    // Helper method to create a mock CustomerEntity
    private CustomerEntity createMockCustomerEntity(int customerId) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerId);
        // Set other properties as needed
        return customerEntity;
    }

    @Test
    void testCreateCustomerWithDuplicateName() {
        // Mocking the repository behavior to simulate a duplicate record
        List<CustomerEntity> duplicateList = new ArrayList<>();
        duplicateList.add(new CustomerEntity());
        when(customerRepository.getCustomersByFirstName(anyString())).thenReturn(duplicateList);

        // Calling the service method
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setFirstName("John");

        // Assertions
        assertThrows(DuplicateRecordException.class, () -> customerService.createCustomer(customerPojo));
        verify(customerRepository, never()).save(any());
    }


    @Test
    void testGetCustomersByCity() {
        // Mocking the repository behavior
        String city = "New York";
        List<CustomerEntity> mockCustomerEntities = new ArrayList<>();
        mockCustomerEntities.add(createMockCustomerEntity());
        
        when(customerRepository.getCustomersByCity(eq(city))).thenReturn(mockCustomerEntities);

        // Calling the service method
        List<CustomerPojo> result = customerService.getCustomersByCity(city);

        // Assertions
        assertFalse(result.isEmpty());
        assertEquals(mockCustomerEntities.size(), result.size());
        verify(customerRepository, times(1)).getCustomersByCity(eq(city));
    }

    @Test
    void testGetCustomersByCityNoResults() {
        // Mocking the repository behavior when no customers are found
        String city = "Nonexistent City";
        when(customerRepository.getCustomersByCity(eq(city))).thenReturn(new ArrayList<>());

        // Assertions
        assertThrows(RecordNotFoundException.class, () -> customerService.getCustomersByCity(city));
        verify(customerRepository, times(1)).getCustomersByCity(eq(city));
    }

    // Helper method to create a mock CustomerEntity
    private CustomerEntity createMockCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName("John");
        customerEntity.setLastName("Doe");
        // Set other properties as needed
        return customerEntity;
    }
  

}

