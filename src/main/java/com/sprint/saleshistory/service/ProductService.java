package com.sprint.saleshistory.service;

import java.util.List;

import com.sprint.saleshistory.models.ProductPojo;



public interface ProductService {
	List<ProductPojo> getAllProducts();
	ProductPojo getProductByProdId(int id);
	ProductPojo addProduct(ProductPojo newProduct);
	ProductPojo updateProduct(ProductPojo updateProduct);
	String deleteProduct(int id);
	
	
	List<ProductPojo> getProductByCategory(String category);
	
	List<ProductPojo> getProductByStatus(String status);
	List<ProductPojo> getProductBySubcategory(String subcategory);
	List<ProductPojo> getProductBySupplierId(int id);
	
	List<ProductPojo> getDuplicateProducts(String prodName);
	
	
	
	
	List<ProductPojo>getSoldProducts(int prodId);
	
	
	List<ProductPojo>getSoldProductByChannel();


	
	
}


