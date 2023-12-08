package com.sprint.saleshistory.entities;
 
import java.math.BigDecimal;

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
 
@Getter
@Setter
@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name = "sales")
	public class SalesEntity {
 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
 
	    @ManyToOne
	    @JoinColumn(name = "prod_id")
	    private ProductEntity product;
 
	    @ManyToOne
	    @JoinColumn(name = "cust_id")
	    private CustomerEntity customer;
 
	    @ManyToOne
	    @JoinColumn(name = "time_id")
	    private TimesEntity time;
 
	    @ManyToOne
	    @JoinColumn(name = "channel_id")
	    private ChannelEntity channel;
 
	    @ManyToOne
	    @JoinColumn(name = "promo_id")
	    private PromotionEntity promotion;
	    
	    
	    @Column(name = "quantity_sold")
	    private int quantitySold;
	    
	    
	    @Column(name = "amount_sold", precision = 10, scale = 2)
	    private BigDecimal amountSold;
	    
	    
	}