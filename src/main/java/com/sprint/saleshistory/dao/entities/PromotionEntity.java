package com.sprint.saleshistory.dao.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

@Entity
@Table(name = "promotions")

public class PromotionEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "promo_id")
	    private int promoId;

	    @Column(name = "promo_name", nullable = false, length = 30)
	    private String promoName;

	    @Column(name = "promo_subcategory", nullable = false, length = 30)
	    private String promoSubcategory;

	    @Column(name = "promo_subcategory_id", nullable = false)
	    private int promoSubcategoryId;

	    @Column(name = "promo_category", nullable = false, length = 30)
	    private String promoCategory;

	    @Column(name = "promo_category_id", nullable = false)
	    private int promoCategoryId;

	    @Column(name = "promo_cost", nullable = false, precision = 10, scale = 2)
	    private BigDecimal promoCost;

	    @Column(name = "promo_begin_date", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date promoBeginDate;

	    @Column(name = "promo_end_date", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private Date promoEndDate;

	    @Column(name = "promo_total", nullable = false, length = 15)
	    private String promoTotal;

	    @Column(name = "promo_total_id", nullable = false)
	    private int promoTotalId;
	}


