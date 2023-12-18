package com.sprint.saleshistory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.saleshistory.dao.ProductRepository;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.ProductPojo;

@SpringBootTest
class ProductServiceImplTest {


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
	void testGetProductsBySubcategory() {
		  // TODO: Implement the test for getProductsBySubcategory
        String subcategory = "Subcategory1";
        List<ProductEntity> stuffedData = productEntities.stream()
                .filter(entity -> entity.getProdSubcategory().equals(subcategory)).toList();
        when(productRepository.findByProdSubcategory(subcategory)).thenReturn(stuffedData);
        List<ProductPojo> expectedProducts = convertEntitiesToPojo(stuffedData);
        List<ProductPojo> actualProducts = productServiceImpl.getProductsBySubcategory(subcategory);
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(expectedProducts));
        verify(productRepository).findByProdSubcategory(subcategory);
    }
	
	@Test
    void testGetProductsBySubcategoryException() {
        // TODO: Implement the test for getProductsBySubcategory exception
        String subcategory = "NonexistentSubcategory";
        when(productRepository.findByProdSubcategory(subcategory)).thenReturn(new ArrayList<>());
        String expectedMessage = "Product list for the subcategory is empty";
        EmptyListException actualException = assertThrows(EmptyListException.class,
                () -> productServiceImpl.getProductsBySubcategory(subcategory));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(productRepository).findByProdSubcategory(subcategory);
    }

	@Test
	void testGetProductsBySupplierId() {
		   // TODO: Implement the test for getProductsBySupplierId
        int supplierId = 1;
        List<ProductEntity> stuffedData = productEntities.stream()
                .filter(entity -> entity.getSupplierId() == supplierId).toList();
        when(productRepository.findBySupplierId(supplierId)).thenReturn(stuffedData);
        List<ProductPojo> expectedProducts = convertEntitiesToPojo(stuffedData);
        List<ProductPojo> actualProducts = productServiceImpl.getProductsBySupplierId(supplierId);
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(expectedProducts));
        verify(productRepository).findBySupplierId(supplierId);
    }
	
	@Test
    void testGetProductsBySupplierIdException() {
        // TODO: Implement the test for getProductsBySupplierId exception
        int supplierId = 99; // Choose a supplierId that does not exist in the data
        when(productRepository.findBySupplierId(supplierId)).thenReturn(new ArrayList<>());
        String expectedMessage = "Product list for the supplier is empty";
        EmptyListException actualException = assertThrows(EmptyListException.class,
                () -> productServiceImpl.getProductsBySupplierId(supplierId));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(productRepository).findBySupplierId(supplierId);
    }

	@Test
	void testFindDuplicateProducts() {
	     // TODO: Implement the test for findDuplicateProducts
        when(productRepository.findDuplicateProducts()).thenReturn(productEntities);
        List<ProductPojo> expectedProducts = convertEntitiesToPojo(productEntities);
        List<ProductPojo> actualProducts = productServiceImpl.findDuplicateProducts();
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(expectedProducts));
        verify(productRepository).findDuplicateProducts();
    }
	
	@Test
	void testgetDuplicateProductsException() {
	    // Mock the behavior of the productRepository.findDuplicateProducts() to return an empty list
	    when(productRepository.findDuplicateProducts()).thenReturn(Collections.emptyList());

	    // Perform the actual method call and catch the exception
	    EmptyListException exception = assertThrows(EmptyListException.class,
	            () -> productServiceImpl.findDuplicateProducts());

	    // Verify the exception message
	    assertEquals("Product list is empty", exception.getMessage());

	    // Verify that the repository method was called
	    verify(productRepository).findDuplicateProducts();
	}

	  
	@Test
	void testFindProductsByChannelWiseSold() {
		   // TODO: Implement the test for findProductsByChannelWiseSold
        int channelId = 1;
        when(productRepository.findProductsByChannelWiseSold(channelId)).thenReturn(new ArrayList<>());
        RecordNotFoundException actualException = assertThrows(RecordNotFoundException.class,
                () -> productServiceImpl.findProductsByChannelWiseSold(channelId));
        assertEquals("No sold product found for this channel", actualException.getMessage());
        verify(productRepository).findProductsByChannelWiseSold(channelId);
    }
	
	  @Test
	    void testFindProductsByChannelWiseSoldException() {
	        // TODO: Implement the test for findProductsByChannelWiseSold exception
	        int channelId = 99; // Choose a channelId that does not exist in the data
	        when(productRepository.findProductsByChannelWiseSold(channelId)).thenReturn(new ArrayList<>());
	        String expectedMessage = "No sold product found for this channel";
	        RecordNotFoundException actualException = assertThrows(RecordNotFoundException.class,
	                () -> productServiceImpl.findProductsByChannelWiseSold(channelId));
	        assertEquals(expectedMessage, actualException.getMessage());
	        verify(productRepository).findProductsByChannelWiseSold(channelId);
	    }

	@Test
	void testFindProductsOrderByField() {
		   // TODO: Implement the test for findProductsOrderByField
        String field = "prodName";
        when(productRepository.findProductsOrderByField(field)).thenReturn(productEntities);
        List<ProductPojo> expectedProducts = convertEntitiesToPojo(productEntities);
        List<ProductPojo> actualProducts = productServiceImpl.findProductsOrderByField(field);
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(expectedProducts));
        verify(productRepository).findProductsOrderByField(field);
    }
	
	 @Test
	    void testFindProductsOrderByFieldException() {
	        // TODO: Implement the test for findProductsOrderByField exception
	        String field = "NonexistentField"; // Choose a field that does not exist in the data
	        when(productRepository.findProductsOrderByField(field)).thenReturn(new ArrayList<>());
	        String expectedMessage = "Product list ordered by field is empty";
	        EmptyListException actualException = assertThrows(EmptyListException.class,
	                () -> productServiceImpl.findProductsOrderByField(field));
	        assertEquals(expectedMessage, actualException.getMessage());
	        verify(productRepository).findProductsOrderByField(field);
	    }

}
