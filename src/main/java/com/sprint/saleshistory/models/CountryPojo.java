package com.sprint.saleshistory.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

   @Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	
     //@JsonIgnoreProperties(ignoreUnknown = true)
	public class CountryPojo {

		private int countryId;
		private String countryIsoCode;
		private String countryName;
		private String countrySubregion;
		private int countrySubregionId;
		private String countryRegion;
		private int countryRegionId;
		private String countryTotal;
		private int countryTotalId;
		}


