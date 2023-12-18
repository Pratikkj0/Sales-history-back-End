package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.ProductRepository;
import com.sprint.saleshistory.entities.ChannelEntity;
import com.sprint.saleshistory.entities.CustomerEntity;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.ChannelPojo;
import com.sprint.saleshistory.models.ChannelWiseSoldCustomResponse;
import com.sprint.saleshistory.models.CustomerPojo;
import com.sprint.saleshistory.models.ProductPojo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductPojo> getAllProducts() {
		List<ProductEntity> allProductsEntity = productRepository.findAll();
		List<ProductPojo> allProductPojo = new ArrayList<ProductPojo>();
		for (ProductEntity productEntity : allProductsEntity) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojo.add(productPojo);
		}
		if (allProductPojo.isEmpty())
			throw new EmptyListException("Product list is empty!");
		return allProductPojo;
	}

	@Override
	public ProductPojo getProductByProdId(int id) {
		Optional<ProductEntity> opt = productRepository.findById(id);
		if (!opt.isPresent())
			throw new RecordNotFoundException("Product not found!");
		ProductEntity productEntity = opt.get();
		ProductPojo productPojo = new ProductPojo();
		BeanUtils.copyProperties(productEntity, productPojo);
		return productPojo;
	}

	@Override
	public String deleteProduct(int id) {
		Optional<ProductEntity> opt = productRepository.findById(id);
		if (!opt.isPresent())
			throw new RecordNotFoundException("Product not found");
		productRepository.deleteById(id);
		return "susccessfully deleted";
	}

	@Override
	public ProductPojo updateProduct(ProductPojo updateProduct) {
		Optional<ProductEntity> opt = productRepository.findById(updateProduct.getProdId());
		if (!opt.isPresent())
			throw new RecordNotFoundException("Product not found");
		ProductEntity productEntity = new ProductEntity();

		BeanUtils.copyProperties(updateProduct, productEntity);
		productRepository.save(productEntity);
		return updateProduct;
	}

	@Override
	public ProductPojo addProduct(ProductPojo newProduct) {
		
		Optional<ProductEntity> opt = productRepository.findById(newProduct.getProdId());
		
		if (opt.isPresent())
			throw new DuplicateRecordException("Product already exists.");
		;
		ProductEntity productEntity = new ProductEntity();
		
		BeanUtils.copyProperties(newProduct, productEntity);
		productRepository.save(productEntity);
		return newProduct;
	}

	@Override
	public List<ProductPojo> getProductByCategory(String category) {
		List<ProductEntity> allProductsEntityByCategory = productRepository.findByProdCategory(category);
		List<ProductPojo> allProductPojoBycategory = new ArrayList<ProductPojo>();
		for (ProductEntity productEntity : allProductsEntityByCategory) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBycategory.add(productPojo);
		}

		if (allProductPojoBycategory.isEmpty())
			throw new EmptyListException("No products found for category: " + category);
		return allProductPojoBycategory;

	}

	@Override
		public List<ProductPojo> getProductByStatus(String status) {
			List<ProductEntity> allProductsEntityByStatus = productRepository.findByProdStatus(status);
			List<ProductPojo> allProductPojoByStatus = new ArrayList<ProductPojo>();
			for (ProductEntity productEntity : allProductsEntityByStatus) {
				ProductPojo productPojo = new ProductPojo();
				BeanUtils.copyProperties(productEntity, productPojo);
				allProductPojoByStatus.add(productPojo);
			}
			if (allProductPojoByStatus.isEmpty())
				throw new EmptyListException("No products found for status: " + status);
			return allProductPojoByStatus; 
	}

	@Override
	public List<ProductPojo> getProductsBySubcategory(String subcategory) {
		List<ProductEntity> productsBySubcategoryEntity = productRepository.findByProdSubcategory(subcategory);
	    List<ProductPojo> productsBySubcategoryPojo = new ArrayList<>();
	    for (ProductEntity productEntity : productsBySubcategoryEntity) {
	        ProductPojo productPojo = new ProductPojo();
	        BeanUtils.copyProperties(productEntity, productPojo);
	        productsBySubcategoryPojo.add(productPojo);
	    }
	    if (productsBySubcategoryPojo.isEmpty())
	        throw new EmptyListException("Product list for the subcategory is empty");
	    return productsBySubcategoryPojo;
	}
	

	@Override
	public List<ProductPojo> getProductsBySupplierId(int supplierId) {
		List<ProductEntity> productsBySupplierIdEntity = productRepository.findBySupplierId(supplierId);
	    List<ProductPojo> productsBySupplierIdPojo = new ArrayList<>();
	    for (ProductEntity productEntity : productsBySupplierIdEntity) {
	        ProductPojo productPojo = new ProductPojo();
	        BeanUtils.copyProperties(productEntity, productPojo);
	        productsBySupplierIdPojo.add(productPojo);
	    }
	    if (productsBySupplierIdPojo.isEmpty())
	        throw new EmptyListException("Product list for the supplier is empty");
	    return productsBySupplierIdPojo;
	}

	@Override
	public List<ProductPojo> findDuplicateProducts() {
			List<ProductEntity> duplicateProductsEntity = productRepository.findDuplicateProducts();
	        List<ProductPojo> duplicateProductsPojo = new ArrayList<>();
	        for (ProductEntity productEntity : duplicateProductsEntity) {
	            ProductPojo productPojo = new ProductPojo();
	            BeanUtils.copyProperties(productEntity, productPojo);
	            duplicateProductsPojo.add(productPojo);
	        }
	        if (duplicateProductsPojo.isEmpty())
	            throw new EmptyListException("Duplicate product list is empty");
	        return duplicateProductsPojo;
	    }

	@Override
	public List<ChannelWiseSoldCustomResponse> findProductsByChannelWiseSold(int channelId) {
		List<Object[]> soldProductsByChannelEntity = productRepository.findProductsByChannelWiseSold(channelId);
		if(soldProductsByChannelEntity.isEmpty())
		throw new RecordNotFoundException("No sold product found for this channel");
		
		List<ChannelWiseSoldCustomResponse> list = new ArrayList<ChannelWiseSoldCustomResponse>();
		for(Object[] objectList : soldProductsByChannelEntity) {
			ChannelEntity channelEntity =(ChannelEntity) objectList[0];
			ProductEntity productEntity =(ProductEntity) objectList[1];
			CustomerEntity customerEntity = (CustomerEntity) objectList[2];
			
			ChannelPojo channelPojo =new ChannelPojo();
			BeanUtils.copyProperties(channelEntity, channelPojo);
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			CustomerPojo customerPojo = new CustomerPojo();
			BeanUtils.copyProperties(customerEntity, customerPojo);
			
			list.add(new ChannelWiseSoldCustomResponse(channelPojo,productPojo, customerPojo));	
		}

       return list;
	}

	@Override
	public List<ProductPojo> findProductsOrderByField(String field) {
		List<ProductEntity> productsOrderedByFieldEntity = productRepository.findProductsOrderByField(field);
        List<ProductPojo> productsOrderedByFieldPojo = new ArrayList<>();
        for (ProductEntity productEntity : productsOrderedByFieldEntity) {
            ProductPojo productPojo = new ProductPojo();
            BeanUtils.copyProperties(productEntity, productPojo);
            productsOrderedByFieldPojo.add(productPojo);
        }
        if (productsOrderedByFieldPojo.isEmpty())
            throw new EmptyListException("Product list ordered by field is empty");
        return productsOrderedByFieldPojo;
    }


}
