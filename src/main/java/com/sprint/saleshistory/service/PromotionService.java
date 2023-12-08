package com.sprint.saleshistory.service;

import java.util.List;
import java.util.Optional;

import com.sprint.saleshistory.models.PromotionPojo;

public interface PromotionService {
	
	List<PromotionPojo> getAllPromotions();

    Optional<PromotionPojo> getPromotionById(int promoId);

    PromotionPojo createPromotion(PromotionPojo newPromotion);

    PromotionPojo updatePromotion(PromotionPojo updatePromotion);

    void deletePromotion(int promoId);

}
