package com.sprint.saleshistory.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class SalesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sales_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "prodId")
	private ProductEntity product;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "channel_id")
	private ChannelEntity channel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	private CustomerEntity customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "promo_id")
	private PromotionEntity promotion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_id")
	private TimesEntity times;

	@Column(name = "quantity_sold")
	private int quantitySold;

	@Column(name = "amount_sold")
	private Double amountSold;

}