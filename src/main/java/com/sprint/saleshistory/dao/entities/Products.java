package com.sprint.saleshistory.dao.entities;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Products {
	
	@Id
	private int prodId;
	
	@Column(length = 50, nullable = false)
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
