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

import com.sprint.saleshistory.models.PromotionPojo;
import com.sprint.saleshistory.service.PromotionService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/promotions")

public class PromototionController {
	
	@Autowired
    private PromotionService promotionService;

    // http://localhost:8080/api/v1/promotions
    @GetMapping
    public List<PromotionPojo> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    // http://localhost:8080/api/v1/promotions/1
    @GetMapping("/{promoId}")
    public PromotionPojo getPromotionById(@PathVariable("promoId") int promoId) {
        return promotionService.getPromotionById(promoId).orElse(null);
    }

    // http://localhost:8080/api/v1/promotions
    @PostMapping
    public PromotionPojo createPromotion(@RequestBody PromotionPojo newPromotion) {
        return promotionService.createPromotion(newPromotion);
    }

    // http://localhost:8080/api/v1/promotions/1
    @PutMapping("/{promoId}")
    public PromotionPojo updatePromotion(@PathVariable("promoId") int promoId, @RequestBody PromotionPojo updatePromotion) {
        updatePromotion.setPromoId(promoId);
        return promotionService.updatePromotion(updatePromotion);
    }

    // http://localhost:8080/api/v1/promotions/1
    @DeleteMapping("/{promoId}")
    public void deletePromotion(@PathVariable("promoId") int promoId) {
        promotionService.deletePromotion(promoId);
    }

}
