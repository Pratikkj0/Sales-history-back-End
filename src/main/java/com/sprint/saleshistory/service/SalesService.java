package com.sprint.saleshistory.service;

import com.sprint.saleshistory.entities.SalesEntity;

import com.sprint.saleshistory.models.SalesPojo;

import java.util.Date;
import java.util.List;

//import org.springframework.data.repository.query.Param;

public interface SalesService {
	List<SalesPojo> getAllSales();

	SalesEntity updateSales(int id, SalesEntity updatedSales);

	void deleteSale(int id);

	SalesEntity getSaleById(int id);

	List<SalesEntity> getByDate(Date date);

	List<Object[]> getSalesQuantitySoldByCategoryWise();

	List<Object[]> getCategoryWiseTotalAmountSold();

	List<Object[]> getSumOfAmountSoldForSalesByCategoriesByYear(int year);

	List<Object[]> getSalesQuantitySoldByCategoryWiseByYear(int year);

	List<Object[]> getAllSalesByQuarter(int quarter);

}
