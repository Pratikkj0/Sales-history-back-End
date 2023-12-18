package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.entities.CostEntity;

	@Repository
	public interface CostRepository extends JpaRepository<CostEntity, Integer> {
		
		
		}

	
