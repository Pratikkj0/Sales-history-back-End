package com.sprint.saleshistory.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.entities.CountryEntity;
import com.sprint.saleshistory.models.CountryInfo;
import com.sprint.saleshistory.service.CountryService;

@CrossOrigin

@RestController
@RequestMapping("/api/v1/countries")

public class CountryController{
	 
    private CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    
     @GetMapping
     public ResponseEntity<List<CountryEntity>> getAllCountries() {
         List<CountryEntity> countries = countryService.getAllCountries();
         return new ResponseEntity<>(countries, HttpStatus.OK);
     }
     
     @PostMapping("/addCountry")
     public ResponseEntity<String> addCountry(@RequestBody CountryEntity countryEntity) {
         String savedCountry = countryService.addCountry(countryEntity);
         return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
     }
     
     @PutMapping("/update/{countryId}")
     public ResponseEntity<String> updateCountry(@PathVariable int countryId, @RequestBody CountryEntity updatedCountryEntity) {
         String updatedCountry = countryService.updateCountry(countryId, updatedCountryEntity);
         return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
     }
     
     @DeleteMapping("/{countryId}")
     public ResponseEntity<String> deleteCountry(@PathVariable int countryId) {
         countryService.deleteCountry(countryId);
         return new ResponseEntity<>("Record deleted successfully", HttpStatus.OK);
     }
     
     @GetMapping("/countryName")
     public ResponseEntity<CountryInfo> getCountByCountryName(@RequestParam String countryName) {
    	 CountryInfo countryInfo = countryService.getCountAndCountriesByCountryName(countryName);
         return new ResponseEntity<>(countryInfo, HttpStatus.OK);
     }
     
     @GetMapping("/region")
     public ResponseEntity<CountryInfo> getCountAndCountriesByRegion(@RequestParam String region) {
    	 CountryInfo countryInfo = countryService.getCountAndCountriesByRegion(region);
    	 return new ResponseEntity<>(countryInfo, HttpStatus.OK);
     }
     
     
     @GetMapping("/countsForCountries")
     public ResponseEntity<Map<String, Long>> getCountsForCountries(@RequestParam List<String> countryNames) {
         Map<String, Long> counts = countryService.getCountsForCountries(countryNames);
         return new ResponseEntity<>(counts, HttpStatus.OK);
     }
     
     @GetMapping("/countsForRegion") 
     public ResponseEntity<Map<String, Long>> getCountsForRegion(@RequestParam List<String> regionNames) {
         Map<String, Long> counts = countryService.getCountsForRegion(regionNames);
         return new ResponseEntity<>(counts, HttpStatus.OK);
     }
     
     @GetMapping("/totalCountByCountry")
     public ResponseEntity<Map<String, Long>> getTotalCountByCountry() {
         Map<String, Long> result = countryService.getTotalCountByCountry(); 
         return new ResponseEntity<>(result, HttpStatus.OK);
     }
     
     @GetMapping("/totalCountByRegion")
     public ResponseEntity<Map<String, Long>> getTotalCountByRegion() {
         Map<String, Long> result = countryService.getTotalCountByRegion(); 
         return new ResponseEntity<>(result, HttpStatus.OK);
     }
     
 
}
    
   
   
  
	

    



   

