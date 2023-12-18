package com.sprint.saleshistory.models;

import java.math.BigDecimal;
import java.sql.Date;

import com.sprint.saleshistory.entities.ChannelEntity;
import com.sprint.saleshistory.entities.CostEntity;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.entities.PromotionEntity;
import com.sprint.saleshistory.entities.TimesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class CostPojo {
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public class CostsPojo {

	   private int prodId;
		private Date timeId;
		private int promoId;
		private int channelId;
		private BigDecimal unitCost;
		private BigDecimal unitPrice;
		public Object toCostPojo() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public CostEntity toCostEntity(ProductEntity product, TimesEntity time, PromotionEntity promotion, ChannelEntity channel) {
	        CostEntity costEntity = new CostEntity();
	        costEntity.setProduct(product);
	        costEntity.setTime(time);
	        costEntity.setPromotion(promotion);
	        costEntity.setChannel(channel);
	        costEntity.setUnitCost(this.unitCost);
	        costEntity.setUnitPrice(this.unitPrice);
	        return costEntity;
	    }

	}
}



