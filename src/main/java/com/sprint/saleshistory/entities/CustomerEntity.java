package com.sprint.saleshistory.entities;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "cust_id")
	    private  long customerId;

	 

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

	    @Column(name = "cust_street_address", nullable = false, length = 40)
	    private String streetAddress;

	    @Column(name = "cust_postal_code", nullable = false, length = 10)
	    private String postalCode;

	    @Column(name = "cust_city", nullable = false, length = 30)
	    private String city;

	    @Column(name = "cust_city_id", nullable = false)
	    private int cityId;

	    @Column(name = "cust_state_province", nullable = false, length = 40)
	    private String stateProvince;

	    @Column(name = "cust_state_province_id", nullable = false)
	    private Integer stateProvinceId;

	    @ManyToOne
	    @JoinColumn(name = "country_id")
	    private CountryEntity country;  // Assuming you have a Country entity

	    @Column(name = "cust_main_phone", nullable = false, length = 25)
	    private String mainPhone;

	    @Column(name = "cust_income_level", length = 30)
	    private String income;

	    @Column(name = "cust_credit_limit")
	    private Integer creditLimit;

	    @Column(name = "cust_email", length = 50)
	    private String email;

	    @Column(name = "cust_total", nullable = false, length = 14)
	    private String total;

	    @Column(name = "cust_total_id", nullable = false)
	    private Integer totalId;

	    @Column(name = "cust_src_id")
	    private Integer srcId;

	    @Column(name = "cust_eff_from")
	    private Date effectiveFrom;

	    @Column(name = "cust_eff_to")
	    private Date effectiveTo;

	    @Column(name = "cust_valid", length = 1)
	    private String valid;




}