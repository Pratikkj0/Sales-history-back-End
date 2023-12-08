package com.sprint.saleshistory.models;

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

public class ChannelPojo {
	
	@NotNull
	private int channelId;
	
	@NotNull
    private String channelDesc;
	
	@NotNull
    private String channelClass;
	
	@NotNull
    private int channelClassId;
	
	@NotNull
    private String channelTotal;
	
	@NotNull
    private int channelTotalId;
	
}


