package com.sprint.saleshistory.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductPojo {

	private int prodId;

	@NotNull(message = "ProdName is required ")
	@Size(max = 50, message = "ProdName size should not be greater than 50.")
	private String prodName;

	@NotNull(message = "ProdDesc is required ")
	@Size(max = 4000, message = "ProdDesc size should not be greater than 4000.")
	private String prodDesc;

	@NotNull(message = "ProdSubcategory is required ")
	@Size(max = 50, message = "prodSubcategory size should not be greater than 50.")
	private String prodSubcategory;

	@NotNull(message = "prodSubcategoryId is required ")
	private int prodSubcategoryId;

	@NotNull(message = "prodSubcategoryDesc is required ")
	@Size(max = 2000, message = "prodSubcategoryDesc size should not be greater than 2000.")
	private String prodSubcategoryDesc;

	@NotNull(message = "prodCategory is required ")
	@Size(max = 50, message = "prodcategory size should not be greater than 50.")
	private String prodCategory;

	@NotNull(message = "prodCategoryId is required ")
	private int prodCategoryId;

	@NotNull(message = "prodCategoryDesc is required ")
	@Size(max = 2000, message = "prodCategoryDesc size should not be greater than 50.")
	private String prodCategoryDesc;

	@NotNull(message = "prodWeightClass is required ")
	private int prodWeightClass;

	@Size(max = 20, message = "prodUnitOfMeasure size should not be greater than 20.")
	private String prodUnitOfMeasure;

	@NotNull(message = "prodPackSize is required ")
	@Size(max = 30, message = "prodPackSize size should not be greater than 30.")
	private String prodPackSize;

	@NotNull(message = "supplierId is required ")
	private int supplierId;

	@NotNull(message = "prodStatus is required ")
	@Size(max = 20, message = "prodStatus size should not be greater than 20.")
	private String prodStatus;

	@NotNull(message = "ProdListPrice is required")
	@Digits(integer = 8, fraction = 2, message = "Invalid decimal format")
	@DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0")
	private BigDecimal prodListPrice;

	@NotNull(message = "prodMinPrice is required ")
	@Digits(integer = 8, fraction = 2, message = "Invalid decimal format")
	@DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0")
	private BigDecimal prodMinPrice; 

	@NotNull(message = "prodTotal is required ")
	@Size(max = 13, message = "prodTotal size should not be greater than 13.")
	private String prodTotal;

	@NotNull(message = "prodTotalId is required ")
	private int prodTotalId;

	private int prodSrcId;

	private LocalDate prodEffFrom;

	private LocalDate prodEffTo;

	private String prodValid;

}
