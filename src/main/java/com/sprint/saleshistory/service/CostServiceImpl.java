package com.sprint.saleshistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.CostRepository;
import com.sprint.saleshistory.entities.CostEntity;
import com.sprint.saleshistory.exception.CostsServiceException;

@Service
public class CostServiceImpl implements CostService {

	private final CostRepository costRepository;

	@Autowired
	public CostServiceImpl(CostRepository costRepository) {
		this.costRepository = costRepository;
	}

	
	
	@Override
	public List<CostEntity> getAllCosts() {
		try {
			if (null != costRepository.findAll() && costRepository.findAll().size() > 0) {
				return costRepository.findAll();
			} else {
				throw new CostsServiceException("no costs objects found");
			}
		} catch (Exception ex) {
			throw new CostsServiceException("no costs objects found");
		}
	}
	
	

	
}
