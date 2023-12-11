package com.sprint.saleshistory.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
