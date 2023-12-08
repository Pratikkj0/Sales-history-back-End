package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.saleshistory.entities.PromotionEntity;


@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {

}
