package com.sprint.saleshistory.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	private String prodValid;
	
	
	

}
