package com.sprint.saleshistory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.saleshistory.dao.entities.ProductEntity;
import com.sprint.saleshistory.models.ProductPojo;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	List<ProductEntity> findByProdCategory(String category); 
	List<ProductEntity> findByProdStatus(String status); 
	List<ProductEntity> findByProdSubcategory(String subcategory); 
	List<ProductEntity> findBySupplierId(int supplierId); 
	List<ProductEntity> findByProdName(String prodName);
	
}
