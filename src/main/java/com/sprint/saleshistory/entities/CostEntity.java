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
@NoArgsConstructor
@AllArgsConstructor
@ToString
 
	@Entity
	@Table(name = "costs")
	public class CostEntity {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Id;
 
	    @ManyToOne
	    @JoinColumn(name = "prod_id", nullable = false)
	    private ProductEntity product;
	    
	    @ManyToOne
	    @JoinColumn(name="time_id" , nullable = false)
	    private TimesEntity time;
	    
	    @ManyToOne
	    @JoinColumn(name="promo_id")
	    private PromotionsEntity promotion;
	    
	    @ManyToOne
	    @JoinColumn(name="channel_id")
	    private ChannelEntity channel;

	   

 
	    @Column(name = "unit_cost", nullable = false)
	    private BigDecimal unitCost;
	    
	    @Column(name = "unit_price", nullable = false)
	    private BigDecimal unitPrice;

 
	
}