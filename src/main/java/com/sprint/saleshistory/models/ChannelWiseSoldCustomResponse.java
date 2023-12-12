package com.sprint.saleshistory.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelWiseSoldCustomResponse {
	private ChannelPojo channelPojo;
	private ProductPojo productPojo;
	private CustomerPojo customerPojo;
}
