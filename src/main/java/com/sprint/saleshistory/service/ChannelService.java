package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.saleshistory.dao.ChannelRepository;
import com.sprint.saleshistory.models.ChannelPojo;

public interface ChannelService {
	
	List<ChannelPojo> getAllChannels();
	
    Optional<ChannelPojo> getChannelById(int channelId);
    
    ChannelPojo createChannel(ChannelPojo newChannel);
    
    ChannelPojo updateChannel(ChannelPojo updateChannel);
    
    void deleteChannel(int channelId);
	

}
