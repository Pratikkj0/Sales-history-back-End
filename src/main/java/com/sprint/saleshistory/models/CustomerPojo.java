package com.sprint.saleshistory.models;

import java.time.LocalDate;
import java.util.Date;

import com.sprint.saleshistory.entities.CountryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CustomerPojo {

	 private Long customerId;
	    private String firstName;
	    private String lastName;
	    private char gender;
	    private Integer yearOfBirth;
	    private String maritalStatus;
	    private String streetAddress;
	    private String postalCode;
	    private String city;
	    private Integer cityId;
	    private String stateProvince;
	    private Integer stateProvinceId;
	    private CountryEntity country;  
	    private String mainPhone;
	    private String income;
	    private Integer creditLimit;
	    private String email;
	    private String total;
	    private Integer totalId;
	    private Integer srcId;
	    private Date effectiveFrom;
	    private Date effectiveTo;
	    private String valid;


}

