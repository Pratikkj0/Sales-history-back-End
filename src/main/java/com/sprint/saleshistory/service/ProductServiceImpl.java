package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.ProductRepository;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
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
			throw new EmptyListException("Product list is empty");
		return allProductPojo;
	}

	@Override
	public ProductPojo getProductByProdId(int id) {
		Optional<ProductEntity> opt = productRepository.findById(id);
		if (!opt.isPresent())
			throw new RecordNotFoundException("Product not found");
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
			throw new EmptyListException("Product list is empty");
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
			throw new EmptyListException("Product list is empty");
		return allProductPojoByStatus;
	}

	@Override
	public List<ProductPojo> getProductBySubcategory(String subcategory) {
		List<ProductEntity> allProductsEntityBySubcategory = productRepository.findByProdSubcategory(subcategory);
		List<ProductPojo> allProductPojoBySubcategory = new ArrayList<ProductPojo>();
		for (ProductEntity productEntity : allProductsEntityBySubcategory) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBySubcategory.add(productPojo);
		}
		if (allProductPojoBySubcategory.isEmpty())
			throw new EmptyListException("Product list is empty");
		return allProductPojoBySubcategory;
	}

	@Override
	public List<ProductPojo> getProductBySupplierId(int id) {
		List<ProductEntity> allProductsEntityBySupplierId = productRepository.findBySupplierId(id);
		List<ProductPojo> allProductPojoBySupplierID = new ArrayList<ProductPojo>();
		for (ProductEntity productEntity : allProductsEntityBySupplierId) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoBySupplierID.add(productPojo);
		}
		if (allProductPojoBySupplierID.isEmpty())
			throw new EmptyListException("Product list is empty");
		return allProductPojoBySupplierID;
	}

	@Override
	public List<ProductPojo> getDuplicateProducts(String prodName) {
		List<ProductEntity> allProductsEntityByProdName = productRepository.findByProdName(prodName);
		List<ProductPojo> allProductPojoByProdName = new ArrayList<ProductPojo>();
		for (ProductEntity productEntity : allProductsEntityByProdName) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			allProductPojoByProdName.add(productPojo);
		}
		if (allProductPojoByProdName.isEmpty())
			throw new EmptyListException("Product list is empty");
		return allProductPojoByProdName;
	}

	@Override
	public List<ProductPojo> getSoldProducts(int prodId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ProductPojo> getSoldProductByChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ProductPojo> getProductOrderByQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
