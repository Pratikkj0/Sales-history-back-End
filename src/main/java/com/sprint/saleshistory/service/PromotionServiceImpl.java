package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.PromotionRepository;
import com.sprint.saleshistory.dao.entities.PromotionEntity;
import com.sprint.saleshistory.models.PromotionPojo;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
    private PromotionRepository promotionRepository;

	@Override
	public List<PromotionPojo> getAllPromotions() {
		
		List<PromotionEntity> allPromotionsEntity = promotionRepository.findAll();
        List<PromotionPojo> allPromotionsPojo = new ArrayList<>();
        for (PromotionEntity promotionEntity : allPromotionsEntity) {
            PromotionPojo promotionPojo = new PromotionPojo();
            BeanUtils.copyProperties(promotionEntity, promotionPojo);
            allPromotionsPojo.add(promotionPojo);
        }
        return allPromotionsPojo;
	}

	@Override
	public Optional<PromotionPojo> getPromotionById(int promoId) {
		
		Optional<PromotionEntity> promotionEntityOptional = promotionRepository.findById(promoId);

        if (promotionEntityOptional.isPresent()) {
            PromotionPojo promotionPojo = new PromotionPojo();
            BeanUtils.copyProperties(promotionEntityOptional.get(), promotionPojo);
            return Optional.of(promotionPojo);
        } else {
            return Optional.empty();
        }
	}

	@Override
	public PromotionPojo createPromotion(PromotionPojo newPromotion) {
		
		 PromotionEntity promotionEntity = new PromotionEntity();
	        BeanUtils.copyProperties(newPromotion, promotionEntity);
	        PromotionEntity savedPromotionEntity = promotionRepository.save(promotionEntity);
	        PromotionPojo savedPromotionPojo = new PromotionPojo();
	        BeanUtils.copyProperties(savedPromotionEntity, savedPromotionPojo);

	        return savedPromotionPojo;
	}

	@Override
	public PromotionPojo updatePromotion(PromotionPojo updatePromotion) {
		
		Optional<PromotionEntity> existingPromotionOptional = promotionRepository.findById(updatePromotion.getPromoId());

        if (existingPromotionOptional.isPresent()) {
            PromotionEntity existingPromotionEntity = existingPromotionOptional.get();
            BeanUtils.copyProperties(updatePromotion, existingPromotionEntity);
            PromotionEntity updatedPromotionEntity = promotionRepository.save(existingPromotionEntity);
            PromotionPojo updatedPromotionPojo = new PromotionPojo();
            BeanUtils.copyProperties(updatedPromotionEntity, updatedPromotionPojo);

            return updatedPromotionPojo;
        } else {
            return null;
        }
	}

	@Override
	public void deletePromotion(int promoId) {
		
		Optional<PromotionEntity> existingPromotionOptional = promotionRepository.findById(promoId);

        if (existingPromotionOptional.isPresent()) {
            promotionRepository.deleteById(promoId);
        } else {
            System.out.println("Promotion with ID " + promoId + " not found. Unable to delete.");
        }
		
	}
	

}
