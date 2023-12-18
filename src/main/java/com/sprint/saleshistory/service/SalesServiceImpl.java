package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.SaleRepository;
import com.sprint.saleshistory.entities.ChannelEntity;
import com.sprint.saleshistory.entities.CustomerEntity;
import com.sprint.saleshistory.entities.ProductEntity;
import com.sprint.saleshistory.entities.PromotionEntity;
import com.sprint.saleshistory.entities.SalesEntity;
import com.sprint.saleshistory.entities.TimesEntity;
import com.sprint.saleshistory.models.ChannelPojo;
import com.sprint.saleshistory.models.CustomerPojo;
import com.sprint.saleshistory.models.ProductPojo;
import com.sprint.saleshistory.models.PromotionPojo;
import com.sprint.saleshistory.models.SalesPojo;
import com.sprint.saleshistory.models.TimesPojo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SaleRepository saleRepository;

	@Override
	public List<SalesPojo> getAllSales() {
		List<SalesEntity> allSalesEntity = saleRepository.findAll();
		List<SalesPojo> allSalesPojo = new ArrayList<>();
		for (SalesEntity salesEntity : allSalesEntity) {
			SalesPojo salesPojo = new SalesPojo();
			BeanUtils.copyProperties(salesEntity, salesPojo);
			allSalesPojo.add(salesPojo);

			ProductEntity productEntity = salesEntity.getProduct();
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(productEntity, productPojo);
			salesPojo.setProductPojo(productPojo);

			PromotionEntity promotionEntity = salesEntity.getPromotion();
			PromotionPojo promotionPojo = new PromotionPojo();
			BeanUtils.copyProperties(promotionEntity, promotionPojo);
			salesPojo.setPromotionPojo(promotionPojo);

			TimesEntity timesEntity = salesEntity.getTimes();
			TimesPojo timesPojo = new TimesPojo();
			BeanUtils.copyProperties(timesEntity, timesPojo);
			salesPojo.setTimesPojo(timesPojo);

			ChannelEntity channelEntity = salesEntity.getChannel();
			ChannelPojo channelPojo = new ChannelPojo();
			BeanUtils.copyProperties(channelEntity, channelPojo);
			salesPojo.setChannelPojo(channelPojo);

			CustomerEntity customerEntity = salesEntity.getCustomer();
			CustomerPojo customerPojo = new CustomerPojo();
			BeanUtils.copyProperties(customerEntity, customerPojo);
			salesPojo.setCustomerPojo(customerPojo);

		}
		return allSalesPojo;
	}

	@Override
	public SalesEntity getSaleById(int id) {
		Optional<SalesEntity> salesOptional = saleRepository.findById(id);
		return salesOptional.orElse(null);
	}

	@Override
	public SalesEntity updateSales(int id, SalesEntity updatedSales) {
		SalesEntity existingSales = getSaleById(id);

		if (existingSales != null) {
			// Update the existing sales entity with the new information
			existingSales.setQuantitySold(updatedSales.getQuantitySold());
			existingSales.setAmountSold(updatedSales.getAmountSold());

			return saleRepository.save(existingSales);
		}
		return null; // Return null or handle as appropriate if the entity doesn't exist
	}

	@Override
	public void deleteSale(int id) {
		Optional<SalesEntity> existingSalesOptional = saleRepository.findById(id);

		if (existingSalesOptional.isPresent()) {
			saleRepository.deleteById(id);
		} else {
			System.out.println("Promotion with ID " + id + " not found. Unable to delete.");
		}
	}

	@Override
	public List<SalesEntity> getByDate(Date date) {
		return saleRepository.findByDate(date);
	}

	@Override
	public List<Object[]> getAllSalesByQuarter(int quarter) {
		return saleRepository.findAllSalesByQuarter(quarter);
	}

	@Override
	public List<Object[]> getSalesQuantitySoldByCategoryWise() {
		return saleRepository.getCategoryBasedCount();
	}

	@Override
	public List<Object[]> getSalesQuantitySoldByCategoryWiseByYear(int year) {
		return saleRepository.findSalesQuantitySoldByCategoryWiseByYear(year);

	}

	@Override
	public List<Object[]> getCategoryWiseTotalAmountSold() {
		return saleRepository.getCategoryWiseTotalAmountSold();

	}

	@Override
	public List<Object[]> getSumOfAmountSoldForSalesByCategoriesByYear(int year) {
		return saleRepository.findSumOfAmountSoldForSalesByCategoriesByYear(year);
	}

}
