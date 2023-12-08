package com.sprint.saleshistory.models;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class PromotionPojo {
	
	@NotNull
	private int promoId;
	
	@NotNull
	private String promoName;
	
	@NotNull
	private String promoSubcategory;
	
	@NotNull
	private int promoSubcategoryId;
	
	@NotNull
	private String promoCategory;
	
	@NotNull
	private int promoCategoryId;
	
	@NotNull
	private BigDecimal promoCost;
	
	@NotNull
	private Date promoBeginDate;
	
	@NotNull
	private Date promoEndDate;
	
	@NotNull
	private String promoTotal;
	
	@NotNull
	private int promoTotalId;
	}
