package com.sprint.saleshistory.entities;

import java.sql.Date;

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
import lombok.ToString;
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
    @Column(name = "country_iso_code", length = 2, nullable = false)
    private String countryIsoCode;
    @Column(name = "country_name", length = 40, nullable = false)
    private String countryName;
    @Column(name = "country_subregion", length = 30)
    private String countrySubregion;
    @Column(name = "country_subregion_id")
    private int countrySubregionId;
    @Column(name = "country_region", length = 40)
    private String countryRegion;
    @Column(name = "country_region_id")
    private int countryRegionId;
    @Column(name = "country_total", length = 11)
    private String countryTotal;
    @Column(name = "country_total_id")
    private int countryTotalId;
}










