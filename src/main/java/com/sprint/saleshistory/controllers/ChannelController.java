package com.sprint.saleshistory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.models.ChannelPojo;
import com.sprint.saleshistory.service.ChannelService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {
	@Autowired
    private ChannelService channelService;

    // http://localhost:8080/api/v1/channels
    @GetMapping
    List<ChannelPojo> getAllChannels() {
        return channelService.getAllChannels();
    }

    // http://localhost:8080/api/v1/channels/1
    @GetMapping("/{channelId}")
    ChannelPojo getChannelById(@PathVariable("channelId") int channelId) {
        return channelService.getChannelById(channelId).orElse(null);
    }

    // http://localhost:8080/api/v1/channels
    @PostMapping
    ChannelPojo createChannel(@RequestBody ChannelPojo newChannelPojo) {
        return channelService.createChannel(newChannelPojo);
    }

    // http://localhost:8080/api/v1/channels/1
    @PutMapping("/{channelId}")
    ChannelPojo updateChannel(@PathVariable("channelId") int channelId, @RequestBody ChannelPojo updateChannelPojo) {
        updateChannelPojo.setChannelId(channelId);
        return channelService.updateChannel(updateChannelPojo);
    }

    // http://localhost:8080/api/v1/channels/1
    @DeleteMapping("/{channelId}")
    void deleteChannel(@PathVariable("channelId") int channelId) {
        channelService.deleteChannel(channelId);
    }

}
