package com.sprint.saleshistory.models;

import jakarta.validation.constraints.NotNull;
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

public class SalesPojo {

	@NotNull
	private int id;
	@NotNull
	private ProductPojo productPojo;
	@NotNull
	private CustomerPojo customerPojo;
	@NotNull
	private TimesPojo timesPojo;
	@NotNull
	private ChannelPojo channelPojo;
	@NotNull
	private PromotionPojo promotionPojo;
	@NotNull
	private int quantitySold;
	@NotNull
	private Double amountSold;

}
