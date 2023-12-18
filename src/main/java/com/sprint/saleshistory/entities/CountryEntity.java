package com.sprint.saleshistory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor 

@Getter
 @Setter
@Data
@Entity
@Table(name = "countries")
 
public class CountryEntity {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "country_id")
	    private int countryId;
	    @Column(name = "country_iso_code")
	    private String countryIsoCode;
	    @Column(name = "country_name") 
	    private String countryName;
	    @Column(name = "country_subregion")
	    private String countrySubregion;
	    @Column(name = "country_subregion_id")
	    private  String countrySubregionId;
	    @Column(name = "country_region")
	    private String countryRegion;
	    @Column(name = "country_region_id")
	    private String countryRegionId;
	    @Column(name = "country_total")
	    private String countryTotal;
	    @Column(name = "country_total_id")
	    private String countryTotalId;
		
    
}










