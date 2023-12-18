package com.sprint.saleshistory.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.entities.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	
	    List<CustomerEntity> getCustomersByFirstName(String firstName);
	   // List<CustomerEntity> getCustomersById(long id);
	    List<CustomerEntity> getCustomersByCity(String city);
        List<CustomerEntity> getCustomersByIncome(String income);
       
	    List<CustomerEntity> findByCreditLimit(Integer CreditLimit);
        // void deleteCustomer(Long id);
	    
	    

}

	
	

