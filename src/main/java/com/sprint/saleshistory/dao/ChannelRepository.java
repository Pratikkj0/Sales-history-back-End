package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.dao.entities.ChannelEntity;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity, Integer> {

}
