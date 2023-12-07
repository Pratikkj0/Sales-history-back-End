package com.sprint.saleshistory.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name = "country")
	public class Country {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "country_id")
	    private Long countryId;

	    @Column(name = "country_iso_code", length = 2, nullable = false)
	    private String countryIsoCode;

	    @Column(name = "country_name", length = 40, nullable = false)
	    private String countryName;

	    @Column(name = "country_subregion", length = 30, nullable = false)
	    private String countrySubregion;

	    @Column(name = "country_subregion_id", nullable = false)
	    private Integer countrySubregionId;

	    @Column(name = "country_region", length = 40, nullable = false)
	    private String countryRegion;

	    @Column(name = "country_region_id", nullable = false)
	    private Integer countryRegionId;

	    @Column(name = "country_total", length = 10, nullable = false)
	    private String countryTotal;

	    @Column(name = "country_total_id", nullable = false)
	    private Integer countryTotalId;
	}

	

