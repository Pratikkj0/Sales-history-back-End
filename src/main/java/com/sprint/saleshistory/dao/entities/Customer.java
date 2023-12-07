package com.sprint.saleshistory.dao.entities;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long customerId;

    @Column(name = "cust_jd")
    private Integer customerJd;

    @Column(name = "cust_first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "cust_last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "cust_gender", nullable = false, length = 1)
    private char gender;

    @Column(name = "cust_year_of_birth", nullable = false)
    private Integer yearOfBirth;

    @Column(name = "cust_marital_status", length = 20)
    private String maritalStatus;

    // ... other fields ...

    @Column(name = "cust_eff_from")
    private Date effectiveFrom;

    @Column(name = "cust_eff_to")
    private Date effectiveTo;

    @Column(name = "cust_valid", length = 1)
    private String valid;

	public Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirstName(Object firstName2) {
		// TODO Auto-generated method stub
		
	}

    // Getters and Setters

    // You can also add other methods or annotations as needed.
}