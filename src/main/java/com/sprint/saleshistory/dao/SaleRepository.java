package com.sprint.saleshistory.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprint.saleshistory.entities.SalesEntity;
import com.sprint.saleshistory.models.SalesPojo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public interface SaleRepository extends JpaRepository<SalesEntity, Integer> {
	
//QUERY FOR GET_SALES_BY_DATE  (/api/v1/sales?date=date)
	
	@Query("SELECT s FROM SalesEntity s WHERE s.times.timeId = :startDate")
	List<SalesEntity> findByDate(@Param("startDate") Date startDate);
	
//	QUERY FOR GET_SALES_BY_QUARTER  (/api/v1/sales?quarter=month)
	
	 @Query("SELECT t.calendarQuarterDesc, s FROM SalesEntity s JOIN s.times t WHERE t.calendarMonth = :quarter")
	List<Object[]> findAllSalesByQuarter(@Param("quarter") int quarter);
	
//QUERY FOR GET COUNT OF TOTAL SALES RECORDS BY CATEGORY   (/api/v1/sales/qtys/categorywise)
	
	@Query("SELECT p.prodCategory, SUM(s.quantitySold) AS categorybasedCount FROM SalesEntity s JOIN s.product p GROUP BY p.prodCategory")
	List<Object[]> getCategoryBasedCount();
	
// 	QUERY FOR  FIND SALES QUANTITY SOLD BY CATEGORY WISE BY YEAR   (/api/v1/sales/qtys/categorywise/year)
 	
	@Query("SELECT p.prodCategory, SUM(c.quantitySold) FROM SalesEntity c JOIN c.product p "
			+ "WHERE YEAR(c.times.timeId) = :year GROUP BY p.prodCategory")
	List<Object[]> findSalesQuantitySoldByCategoryWiseByYear(@Param("year") int year);
	
//QUERY  FOR SUM OF AMOUNT SOLD FOR SALES RECORDS BY CATEGORIES (/api/v1/sales/sold/categorywise)
	
	@Query("SELECT p.prodCategory, SUM(s.amountSold) " +
	           "FROM SalesEntity s " +
	           "JOIN s.product p " +
	           "GROUP BY p.prodCategory")
	    List<Object[]> getCategoryWiseTotalAmountSold();
  
//QUERY FOR SUM OF AMOUNT FOR SALES RECORDS BY CATEGORIES FOR THE YEAR (api/v1/sales/sold/categorywise/year)    
	    
	    @Query("SELECT p.prodCategory, SUM(c.amountSold) FROM SalesEntity c JOIN c.product p WHERE YEAR(c.times.timeId) = :year "
				+ "GROUP BY YEAR(c.times.timeId), p.prodCategory ORDER BY YEAR(c.times.timeId)")
		public List<Object[]> findSumOfAmountSoldForSalesByCategoriesByYear(@Param("year") int year);
	  
}