package com.sprint.saleshistory.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
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
@Table(name = "products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;

	
	private String prodName;
	
	private String prodDesc;
	
	private String prodSubcategory;
	
	private int prodSubcategoryId;
	
	private String prodSubcategoryDesc;
	
	private String prodCategory;
	
	private int prodCategoryId;
	
	private String prodCategoryDesc;
	
	private int prodWeightClass;
	
	private String prodUnitOfMeasure;
	
	private String prodPackSize;
	
	private int supplierId;
	
	private String prodStatus;
	
	private BigDecimal prodListPrice;
	
	private BigDecimal  prodMinPrice;
	
	private String prodTotal;
	
	private int prodTotalId;
	
	private int prodSrcId;
	
	private LocalDate prodEffFrom;
	
	private LocalDate prodEffTo;
	
 

	@Column(length = 50, nullable = false)
	private String prodName;

	@Column(length = 4000, nullable = false)
	private String prodDesc;

	@Column(length = 50, nullable = false)
	private String prodSubcategory;

	@Column(nullable = false)
	private int prodSubcategoryId;

	@Column(length = 2000, nullable = false)
	private String prodSubcategoryDesc;

	@Column(length = 50, nullable = false)
	private String prodCategory;

	@Column(nullable = false)
	private int prodCategoryId;

	@Column(length = 2000, nullable = false)
	private String prodCategoryDesc;

	@Column(nullable = false)
	private int prodWeightClass;

	@Column(length = 20)
	private String prodUnitOfMeasure;

	@Column(length = 30, nullable = false)
	private String prodPackSize;

	@Column(nullable = false)
	private int supplierId;

	@Column(length = 20, nullable = false)
	private String prodStatus;

	@Column(nullable = false)
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 8, fraction = 2)
	private BigDecimal prodListPrice;

	@Column(nullable = false)
	@Digits(integer = 8, fraction = 2, message = "Invalid decimal format")
	@DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0")
	private BigDecimal prodMinPrice;

	@Column(length = 13, nullable = false)
	private String prodTotal;

	@Column(nullable = false)
	private int prodTotalId;

	private int prodSrcId;

	@Temporal(TemporalType.DATE)
	private LocalDate prodEffFrom;

	@Temporal(TemporalType.DATE)
	private LocalDate prodEffTo;

	@Column(length = 1)
 
	private String prodValid;

}
