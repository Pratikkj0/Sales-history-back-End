package com.sprint.saleshistory.service;

import com.sprint.saleshistory.entities.SalesEntity;
import com.sprint.saleshistory.models.PromotionPojo;
import com.sprint.saleshistory.models.SalesPojo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface SalesService {
   List<SalesPojo> getAllSales();

//List<SalesPojo[]> getCategoryBasedCount(String prodCategory);

//SalesPojo getSaleById(int id);
//SalesEntity createSales(SalesEntity sales);
//   SalesPojo createSales(SalesPojo newSales);


   
SalesEntity updateSales(int id, SalesEntity updatedSales);
void deleteSale(int id);

SalesEntity getSaleById(int id);

List<SalesEntity> getByDate(Date date);

List<SalesEntity> getAllSalesByQuarter(int calendarMonth);

List<Object[]> getSalesQuantitySoldByCategoryWise();

//List<Object[]> getSalesQuantitySoldByCategoryWiseByYear();

//List<Object[]> getSalesQuantitySoldByCategoryWiseByYear();

//List<Object[]> getSumOfAmountSoldForSalesByCategories();

List<Object[]> getCategoryWiseTotalAmountSold();

List<Object[]> getSumOfAmountSoldForSalesByCategoriesByYear(int year);

//List<Object[]> getSalesQuantitySoldByCategoryWiseByYear(Date year);

//List<Object[]> getSalesQuantitySoldByCategoryWiseByYear(int year);

List<Object[]> getSalesQuantitySoldByCategoryWiseByYear(int year);

//List<Object[]> getSalesQuantitySoldByCategoryWiseByYear();

//List<Object[]> getSalesQuantitySoldByCategoryWise();

//List<Object[]> getSalesQuantityByCategoryWise();


//List<SalesEntity> getByDate(Date date);

//List<Object[]> findCategoryBasedCount(String prodCategory);


//List<SalesPojo[]> findCategoryBasedCount(String prodCategory);

//List<Object[]> findCategoryBasedCount(String prodCategory);




   
}
