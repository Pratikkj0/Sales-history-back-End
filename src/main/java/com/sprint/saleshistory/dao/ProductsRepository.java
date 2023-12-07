package com.sprint.saleshistory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.saleshistory.dao.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
