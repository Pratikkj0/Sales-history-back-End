package com.sprint.saleshistory.models;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
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
public class ProductPojo {

	private int prodId;

	@NotNull
	private String prodName;
	
	@NotNull
	private String prodDesc;

	@NotNull
	private String prodSubcategory;

	
	@NotNull
	private int prodSubcategoryId;

	@NotNull
	private String prodSubcategoryDesc;

	@NotNull
	private String prodCategory;

	@NotNull
	private int prodCategoryId;

	@NotNull
	private String prodCategoryDesc;

	@NotNull
	private int prodWeightClass;
	
	
	private String prodUnitOfMeasure;

	@NotNull
	private String prodPackSize;

	@NotNull
	private int supplierId;

	@NotNull
	private String prodStatus;

	@NotNull
	private String prodListPrice;

	@NotNull
	private double ProdMinPrice;

	@NotNull
	private String prodTotal;

	@NotNull
	private int prodTotalId;

	
	private int prodSrcId;
	
	
	private LocalDate prodEffFrom;

	private LocalDate prodEffTo;

	
	
	private String prodValid;

}
