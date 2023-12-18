package com.sprint.saleshistory.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.entities.SalesEntity;
import com.sprint.saleshistory.exception.RecordNotFoundException;
import com.sprint.saleshistory.models.SalesPojo;
//import com.sprint.saleshistory.service.RecordNotFoundException;
import com.sprint.saleshistory.service.SalesService;

@CrossOrigin
@RestController
@RequestMapping("api/v1/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@GetMapping("/all")
	public List<SalesPojo> getAllSales() {
		return salesService.getAllSales();
	}

	@GetMapping("/date/{date}")
	public ResponseEntity<List<SalesEntity>> getByDate(@PathVariable("date") String dateString) {
		Date date;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // or your desired date format
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd format.");
		}

		List<SalesEntity> sales = salesService.getByDate(date);
		if (sales.isEmpty()) {
			throw new RecordNotFoundException("Sales not found on this date: " + date);
		}
		return new ResponseEntity<>(sales, HttpStatus.OK);
	}

	@GetMapping(value = "/quarter/{quarter}")
	public ResponseEntity<List<Object[]>> getAllSalesByQuarter(@PathVariable("quarter") int quarter) {
		List<Object[]> list = salesService.getAllSalesByQuarter(quarter);
		if (list.size() == 0) {
			throw new RecordNotFoundException(" sales not found in this quarter month : " + quarter);
		}
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/qtys/categorywise")
	public ResponseEntity<List<Object[]>> getSalesQuantitySoldByCategoryWise() {
		List<Object[]> list = salesService.getSalesQuantitySoldByCategoryWise();
		if (list.size() == 0) {
			throw new RecordNotFoundException(" sales not found  ");
		}
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public SalesEntity getSaleById(@PathVariable int id) {
		return salesService.getSaleById(id);

	}

	@PutMapping("/{id}")
	public SalesEntity updateSales(@PathVariable int id, @RequestBody SalesEntity updatedSales){
		return salesService.updateSales(id, updatedSales);

	}

	@GetMapping(value = "/qtys/categorywise/{year}")
	public ResponseEntity<List<Object[]>> getSalesQuantitySoldByCategoryWiseByYear(@PathVariable("year") int year) {
		List<Object[]> list = salesService.getSalesQuantitySoldByCategoryWiseByYear(year);
		if (list.size() == 0) {
			throw new RecordNotFoundException(" No sales found in the year : " + year);
		}
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);
	}

	@GetMapping("/sold/categorywise")
	public ResponseEntity<List<Object[]>> getSumOfAmountSoldForSalesByCategories() {

		List<Object[]> list = salesService.getCategoryWiseTotalAmountSold();
		if (list.size() == 0) {
			throw new RecordNotFoundException(" sales not found ");
		}
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteSale(@PathVariable int id) {
		salesService.deleteSale(id);
	}

	@GetMapping(value = "/sold/categorywise/{year}")
	public ResponseEntity<List<Object[]>> getSumOfAmountSoldForSalesByCategoriesByYear(@PathVariable("year") int year) {

		List<Object[]> list = salesService.getSumOfAmountSoldForSalesByCategoriesByYear(year);
		if (list.size() == 0) {
			throw new RecordNotFoundException("No sales sold in this " + year + " year .");
		}
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);
	}

}
