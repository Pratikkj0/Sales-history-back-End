package com.sprint.saleshistory.service;

import java.util.List;

import com.sprint.saleshistory.models.ChannelWiseSoldCustomResponse;
import com.sprint.saleshistory.models.ProductPojo;

public interface ProductService {
	List<ProductPojo> getAllProducts();

	ProductPojo getProductByProdId(int id);

	ProductPojo addProduct(ProductPojo newProduct);

	ProductPojo updateProduct(ProductPojo updateProduct);

	String deleteProduct(int id);

	List<ProductPojo> getProductByCategory(String category);

	List<ProductPojo> getProductByStatus(String status);

	List<ProductPojo> getProductsBySubcategory(String subcategory);

	List<ProductPojo> getProductsBySupplierId(int supplierId);

	List<ProductPojo> findDuplicateProducts();

	List<ChannelWiseSoldCustomResponse> findProductsByChannelWiseSold(int channelId);

	List<ProductPojo> findProductsOrderByField(String field);

}
