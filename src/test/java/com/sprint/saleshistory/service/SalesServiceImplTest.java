package com.sprint.saleshistory.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.saleshistory.dao.SaleRepository;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.entities.SalesEntity;
import com.sprint.saleshistory.exception.EmptyListException;
import com.sprint.saleshistory.exception.RecordNotFoundException;

@SpringBootTest
class SalesServiceImplTest {

	@Mock
	private SaleRepository saleRepository;

	@InjectMocks
	private SalesServiceImpl salesServiceImpl;

	@Test
	public void testGetAllSales() {
		List<SalesEntity> allSalesEntity = new ArrayList<>();
		when(saleRepository.findAll()).thenReturn(allSalesEntity);

		assertNotNull(salesServiceImpl.getAllSales());
	}

	@Test
	public void testGetAllSalesException() {
		when(saleRepository.findAll()).thenThrow(new RecordNotFoundException("No Sales Found"));

		// Assertions
		assertThrows(RuntimeException.class, () -> {
			salesServiceImpl.getAllSales();
		});
	}

	@Test
	public void testGetSaleById() {
		SalesEntity salesOptional = new SalesEntity();
		when(saleRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(salesOptional));

		// Assertions
		assertNotNull(salesServiceImpl.getSaleById(Mockito.anyInt()));
	}

	@Test
	public void testUpdateSalesNULL() {
		SalesEntity updatedSales = new SalesEntity();
		SalesEntity existingSales = new SalesEntity();

		// Assertions
		assertNull(salesServiceImpl.updateSales(Mockito.anyInt(), updatedSales));
	}

	@Test
	public void testUpdateSalesExistingId() {
		int existingId = 1; // Replace with an existing ID in your test data
		SalesEntity existingSalesEntity = new SalesEntity(); // Create a sample SalesEntity object
		SalesEntity updatedSalesEntity = new SalesEntity(); // Create an updated SalesEntity object
		when(saleRepository.findById(existingId)).thenReturn(Optional.of(existingSalesEntity));
		when(saleRepository.save(existingSalesEntity)).thenReturn(existingSalesEntity);
		SalesEntity result = salesServiceImpl.updateSales(existingId, updatedSalesEntity);

		// Assertions
		assertNotNull(result);
		assertEquals(existingSalesEntity, result);
	}

	@Test
	public void testGetByDate() {
		Date testDate = new Date(); // Replace with an actual test date
		SalesEntity saleEntity = new SalesEntity(); // Replace with an actual SalesEntity object
		List<SalesEntity> expectedSalesList = Arrays.asList(saleEntity);
		when(saleRepository.findByDate(any(Date.class))).thenReturn(expectedSalesList);
		List<SalesEntity> result = salesServiceImpl.getByDate(testDate);

		// Assertions
		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(saleEntity, result.get(0));
	}

	@Test
	public void testGetByDateException() {
		Date testDate = new Date(); // Replace with an actual test date

		// Mocking an exception when findByDate is called
		when(saleRepository.findByDate(any(Date.class)))
				.thenThrow(new RecordNotFoundException("No Sales Records Found on this Date"));

		// Using assertThrows to verify that the method throws an exception
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			salesServiceImpl.getByDate(testDate);
		});

		// Verifying the exception message
		assertEquals("No Sales Records Found on this Date", exception.getMessage());
	}

	@Test
	public void testGetAllSalesByQuarter() {
		int testQuarter = 1; // Replace with the actual quarter you want to test

		// Mocked data
		List<Object[]> mockedSales = new ArrayList<>(); // Add mocked SalesEntity objects

		// Mocking the behavior of saleRepository.findAllSalesByQuarter()
		when(saleRepository.findAllSalesByQuarter(testQuarter)).thenReturn(mockedSales);

		// Calling the service method
		List<Object[]> result = salesServiceImpl.getAllSalesByQuarter(testQuarter);

		// Assertions
		Assertions.assertNotNull(result);
	}

	@Test
	public void testGetSalesQuantitySoldByCategoryWise() {
		// Mocking the behavior of saleRepository.getCategoryBasedCount()
		List<Object[]> mockData = new ArrayList<>();

		// Adding some sample data to simulate the expected behavior of the repository
		// method
		Object[] data1 = { "Category1", 10 };
		Object[] data2 = { "Category2", 20 };
		mockData.add(data1);
		mockData.add(data2);
		when(saleRepository.getCategoryBasedCount()).thenReturn(mockData);

		// Calling the service method
		List<Object[]> result = salesServiceImpl.getSalesQuantitySoldByCategoryWise();

		// Assertions
		assertNotNull(result); // Checking if the result is not null
		assertEquals(2, result.size()); // Checking if the result list has two elements (mocked data size)
		assertArrayEquals(data1, result.get(0)); // Checking if the first array is the same as the first mock data
		assertArrayEquals(data2, result.get(1)); // Checking if the second array is the same as the second mock data
	}

	@Test
	public void testGetSalesQuantitySoldByCategoryWiseByYear() {
		int year = 2023; // Provide an actual year for testing

		List<Object[]> mockedData = new ArrayList<>();

		// Adding mocked data as per your requirement
		mockedData.add(new Object[] { "Category1", 1000 });

		// Mock the behavior of
		// saleRepository.findSalesQuantitySoldByCategoryWiseByYear()
		when(saleRepository.findSalesQuantitySoldByCategoryWiseByYear(year)).thenReturn(mockedData);

		// Call the method from the service
		List<Object[]> result = salesServiceImpl.getSalesQuantitySoldByCategoryWiseByYear(year);

		// Assertions
		Assertions.assertNotNull(result);
	}

	@Test
	public void testGetCategoryWiseTotalAmountSold() {
		// Mocked data
		List<Object[]> mockedData = new ArrayList<>();

		// Adding mocked data based on the structure of the returned List<Object[]>
		mockedData.add(new Object[] { "Category1", 1000 });

		// Mocking the behavior of saleRepository.getCategoryWiseTotalAmountSold()
		when(saleRepository.getCategoryWiseTotalAmountSold()).thenReturn(mockedData);

		// Calling the service method
		List<Object[]> result = salesServiceImpl.getCategoryWiseTotalAmountSold();

		// Assertions
		assertNotNull(result);
	}

	@Test
	public void testGetSumOfAmountSoldForSalesByCategoriesByYear() {
		int testYear = 2023; // Provide an actual year for testing
		// Mock data
		List<Object[]> mockResult = new ArrayList<>();

		// Adding example data as per the expected result from the repository method
		mockResult.add(new Object[] { "Category1", 1000 });

		// Mocking the behavior of
		// saleRepository.findSumOfAmountSoldForSalesByCategoriesByYear()
		when(saleRepository.findSumOfAmountSoldForSalesByCategoriesByYear(testYear)).thenReturn(mockResult);

		// Calling the service method
		List<Object[]> result = salesServiceImpl.getSumOfAmountSoldForSalesByCategoriesByYear(testYear);

		// Assertions
		assertEquals(mockResult.size(), result.size()); // Check if the result size matches
	}

}
