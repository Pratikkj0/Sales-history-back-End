package com.sprint.saleshistory.models;

import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

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
public class ProductsPoJo {
	private int prodId;
	private String prodName;
	private String prodDesc;
	private String prodSubcategory;
	private int prodSubcategotyId;
	private String prodSubcategoryDesc;
	private String prodCategory;
	private int prodCategoryId;
	private String prodCategoryDesc;
	private int prodWeightClass;
	private String prodUnitOfMeasure;
	
	private String prodPackSize;
	private int supplierId;
	private String prodStatus;
	private String prodListPrice;
	private double ProdMinPrice;
	private String prodTotal;
	private int prodTotalId;
	private int prodSrcId;
	private LocalDate prodEffFrom;
	private LocalDate prodEffTo;
	private String prodValid;
	
	
	
}
