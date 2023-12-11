package com.sprint.saleshistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.any;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.saleshistory.dao.ProductRepository;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.exception.DuplicateRecordException;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.ProductPojo;
import com.sprint.saleshistory.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	ProductEntity[] entities = new ProductEntity[] {
			new ProductEntity(1, "Product1", "Description1", "Subcategory1", 1, "SubcategoryDesc1", "Category1", 1,
					"CategoryDesc1", 1, "Unit", "PackSize", 1, "Sold", new BigDecimal("10.00"), new BigDecimal("5.00"),
					"Total1", 1, 1, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-12-31"), "Y"),
			
			new ProductEntity(2, "Product2", "Description2", "Subcategory2", 2, "SubcategoryDesc2", "Category2", 2,
					"CategoryDesc2", 2, "Unit", "PackSize", 2, "Sold", new BigDecimal("20.00"), new BigDecimal("10.00"),
					"Total2", 2, 2, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-12-31"), "Y"),
			
			new ProductEntity(3, "Product3", "Description3", "Subcategory3", 3, "SubcategoryDesc3", "Category3", 3,
					"CategoryDesc3", 3, "Unit", "PackSize", 3, "Unsold", new BigDecimal("30.00"),new BigDecimal("15.00"), 
					"Total3", 3, 3, LocalDate.parse("2023-01-01"),LocalDate.parse("2023-12-31"), "N"),
			
			new ProductEntity(4, "Product4", "Description4", "Subcategory4", 4, "SubcategoryDesc4", "Category4", 4,
					"CategoryDesc4", 4, "Unit", "PackSize", 4, "Sold", new BigDecimal("40.00"), new BigDecimal("20.00"),
					"Total4", 4, 4, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-12-31"), "Y"),
			
			new ProductEntity(5, "Product5", "Description5", "Subcategory5", 5, "SubcategoryDesc5", "Category5", 5,
					"CategoryDesc5", 5, "Unit", "PackSize", 5, "Sold", new BigDecimal("50.00"), new BigDecimal("25.00"),
					"Total5", 5, 5, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-12-31"), "Y")

	};

	List<ProductEntity> productEntities = Arrays.asList(entities);

	List<ProductPojo> productPojos = convertEntitiesToPojo(productEntities);

	public List<ProductPojo> convertEntitiesToPojo(List<ProductEntity> productEntities) {
		return productEntities.stream().map(entity -> {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(entity, productPojo);
			return productPojo;
		}).collect(Collectors.toList());
	}

	@Test
	public void testGetAllProducts() {
		when(productRepository.findAll()).thenReturn(productEntities);
		List<ProductPojo> expectedAllProducts = productPojos;
		List<ProductPojo> actualAllProducts = productServiceImpl.getAllProducts();
		assertEquals(expectedAllProducts.size(), actualAllProducts.size());
		verify(productRepository).findAll();
	}

	@Test
	public void testGetAllProductsException() {
		when(productRepository.findAll()).thenReturn(new ArrayList<ProductEntity>());
		String expectedMessage = "Product list is empty!";
		EmptyListException actualException = assertThrows(EmptyListException.class,
				() -> productServiceImpl.getAllProducts());
		String actualMessage = actualException.getMessage();
		assertEquals(expectedMessage, actualMessage);
		verify(productRepository).findAll();
	}

	@Test
	public void testGetProductByProdId() {

		when(productRepository.findById(1)).thenReturn(Optional.ofNullable(productEntities.get(0)));

		ProductPojo actualData = productServiceImpl.getProductByProdId(1);
		assertEquals(productPojos.get(0), actualData);
//		assertTrue(actualData.equals(productPojos.get(0)));   //to clear with ma'm 
		verify(productRepository).findById(1);

	}

	@Test
	public void testGetProductByIdException() {

		when(productRepository.findById(10)).thenReturn(Optional.ofNullable(null));
		String expectedMessage = "Product not found!";
		RecordNotFoundException actualException = assertThrows(RecordNotFoundException.class,
				() -> productServiceImpl.getProductByProdId(10));
		String actualMessage = actualException.getMessage();
		assertEquals(expectedMessage, actualMessage);
		verify(productRepository).findById(10);
	}

	@Test
	public void testGetProductByCategory() {
		String category = "Category1";
		List<ProductEntity> stuffedData = productEntities.stream()
				.filter(entity -> entity.getProdCategory().equals(category)).toList();
		
		when(productRepository.findByProdCategory(category)).thenReturn(stuffedData);
		
		List<ProductPojo> expectedProducts = convertEntitiesToPojo(stuffedData);
		List<ProductPojo> actualProducts = productServiceImpl.getProductByCategory(category);
		
		assertEquals(expectedProducts.size(), actualProducts.size());
		assertTrue(actualProducts.containsAll(expectedProducts));
		verify(productRepository).findByProdCategory(category);
	}

	@Test
	public void testGetProductByCategoryException() {
	    String category = "Category10";
	    when(productRepository.findByProdCategory(category)).thenReturn(new ArrayList<>());
	    String expectedMessage = "No products found for category: " + category;
	    EmptyListException actualException = assertThrows(EmptyListException.class,
	            () -> productServiceImpl.getProductByCategory(category));
	    assertEquals(expectedMessage, actualException.getMessage());
	    verify(productRepository).findByProdCategory(category);
	}
	
	@Test
	public void testGetProductByStatus() {

		String[] statuses = { "Sold", "Unsold" };

		for (String status : statuses) {
			List<ProductEntity> stuffedData = productEntities.stream()
					.filter(entity -> entity.getProdStatus().equals(status)).toList();

			when(productRepository.findByProdStatus(status)).thenReturn(stuffedData);

			List<ProductPojo> expectedProducts = convertEntitiesToPojo(stuffedData);
			List<ProductPojo> actualProducts = productServiceImpl.getProductByStatus(status);

			assertEquals(expectedProducts.size(), actualProducts.size());
			assertTrue(actualProducts.containsAll(expectedProducts));
			verify(productRepository).findByProdStatus(status);
		}

	}
	    
	
	
	@Test
	public void testGetProductByStatusException() {
		
	    String status = "Unsold";

	    when(productRepository.findByProdStatus(status)).thenReturn(new ArrayList<>());

	    String expectedMessage = "No products found for status: " + status;

	    EmptyListException actualException = assertThrows(EmptyListException.class,
				() -> productServiceImpl.getProductByStatus(status));
	    
		String actualMessage = actualException.getMessage();
		
		assertEquals(expectedMessage, actualMessage);
	    verify(productRepository).findByProdStatus(status);
	}

	
	
	
	
	
	
	
		
	@Test
	public void testDeleteProdById() {
	    
	    int productIdToDelete = 1;
	    when(productRepository.findById(productIdToDelete)).thenReturn(Optional.ofNullable(entities[0]));
	 
	    String expectedMessage = "susccessfully deleted";
	    String actualMessage =productServiceImpl.deleteProduct(productIdToDelete);
	    assertEquals(expectedMessage, actualMessage);
	    assertTrue(expectedMessage.equals(actualMessage));
	    verify(productRepository).deleteById(productIdToDelete);	    
	    
	}
	
	@Test
	public void testDeleteProdByIdException() {

	    int productIdToDelete = 10; 
	    
	    when(productRepository.findById(productIdToDelete)).thenReturn(Optional.empty());

	    String expectedMessage = "Product not found";
	    RecordNotFoundException actualException =assertThrows(RecordNotFoundException.class, 
	    		() -> productServiceImpl.deleteProduct(productIdToDelete));
		String actualMessage = actualException.getMessage();

	    assertEquals(expectedMessage, actualMessage);

	    verify(productRepository, never()).deleteById(anyInt());
	  //  verify(productRepository).deleteById(productIdToDelete);	
}
	

	
	
	
	
	
	
	
	
	@Test
	public void testAddProduct() {
		ProductPojo productPojo = new ProductPojo(10, null, null, null, 0, null, null, 0, null, 0, null, null, 0, null, null, null, null, 0, 0, null, null, null);
	    when(productRepository.findById(10)).thenReturn(Optional.ofNullable(null));
	 
		ProductPojo actualProductPojo = productServiceImpl.addProduct(productPojo);
	    	    
		assertEquals(productPojo, actualProductPojo);
		assertTrue(productPojo.equals(actualProductPojo));
	    
	
	}
	
	@Test
	public void testAddProductException() {
	    // Arrange
	    int existingProductId = 10;  // Choose an existing product ID for the test
	    ProductPojo productPojo = new ProductPojo(existingProductId, null, null, null, 0, null, null, 0, null, 0, null, null, 0, null, null, null, null, 0, 0, null, null, null);

	    String expectedMessage = "Product already exists.";
	    when(productRepository.findById(existingProductId)).thenReturn(Optional.ofNullable(new ProductEntity()));
	    
	    DuplicateRecordException actualException = assertThrows(DuplicateRecordException.class, () -> productServiceImpl.addProduct(productPojo));
	    String actualMessage = actualException.getMessage();

	    assertEquals(expectedMessage, actualMessage);
	    
	    verify(productRepository).findById(existingProductId);
	    verify(productRepository, never()).save(any(ProductEntity.class));
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
