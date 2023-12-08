package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.ChannelRepository;
import com.sprint.saleshistory.entities.ChannelEntity;
import com.sprint.saleshistory.models.ChannelPojo;

@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Autowired
	ChannelRepository channelRepository;

	@Override
	public List<ChannelPojo> getAllChannels() {
		List<ChannelEntity> allChannelsEntity = channelRepository.findAll();
		List<ChannelPojo> allChannelsPojo = new ArrayList<>();
	    for (ChannelEntity channelEntity : allChannelsEntity) {
	    	ChannelPojo channelPojo = new ChannelPojo();
	        BeanUtils.copyProperties(channelEntity, channelPojo);
	        allChannelsPojo.add(channelPojo);
	    }
		
		return allChannelsPojo;
	}

	@Override
	public Optional<ChannelPojo> getChannelById(int channelId) {
		
		Optional<ChannelEntity> channelEntityOptional = channelRepository.findById(channelId);

	    if (channelEntityOptional.isPresent()) {
	        ChannelPojo channelPojo = new ChannelPojo();
	        BeanUtils.copyProperties(channelEntityOptional.get(), channelPojo);
	        return Optional.of(channelPojo);
	    } else {
	        return Optional.empty();
	    }
	}

	@Override
	public ChannelPojo createChannel(ChannelPojo newChannel) {
		
		ChannelEntity channelEntity = new ChannelEntity();
	    BeanUtils.copyProperties(newChannel, channelEntity);
	    ChannelEntity savedChannelEntity = channelRepository.save(channelEntity);
	    ChannelPojo savedChannelPojo = new ChannelPojo();
	    BeanUtils.copyProperties(savedChannelEntity, savedChannelPojo);

	    return savedChannelPojo;
	}

	@Override
	public ChannelPojo updateChannel(ChannelPojo updateChannel) {
		

		Optional<ChannelEntity> existingChannelOptional = channelRepository.findById(updateChannel.getChannelId());

	    if (existingChannelOptional.isPresent()) {
	        ChannelEntity existingChannelEntity = existingChannelOptional.get();
	        BeanUtils.copyProperties(updateChannel, existingChannelEntity);
	        ChannelEntity updatedChannelEntity = channelRepository.save(existingChannelEntity);
	        ChannelPojo updatedChannelPojo = new ChannelPojo();
	        BeanUtils.copyProperties(updatedChannelEntity, updatedChannelPojo);

	        return updatedChannelPojo;
	    } else {
	        return null;
	    }
	}

	@Override
	public void deleteChannel(int channelId) {
	
		
		Optional<ChannelEntity> existingChannelOptional = channelRepository.findById(channelId);

	    if (existingChannelOptional.isPresent()) {
	        channelRepository.deleteById(channelId);
	    } else {
	       
	        System.out.println("Channel with ID " + channelId + " not found. Unable to delete.");
	    }
	}
}	
