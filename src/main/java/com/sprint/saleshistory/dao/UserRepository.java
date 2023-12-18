package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.saleshistory.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	UserEntity findByUserName(String name);
	
}
