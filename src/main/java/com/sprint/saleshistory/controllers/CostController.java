package com.sprint.saleshistory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.entities.CostEntity;
import com.sprint.saleshistory.entities.CountryEntity;
import com.sprint.saleshistory.models.CostPojo;
import com.sprint.saleshistory.models.CostPojo.CostsPojo;
import com.sprint.saleshistory.service.CostService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/costs")
public class CostController {

    private final CostService costService;

    @Autowired
    public CostController(CostService costService) {
        this.costService = costService;
    }
    @GetMapping
    public List<CostEntity> getAllCosts() {
        return costService.getAllCosts();
    }
    
	/*
	 * @GetMapping("/{costId}") public CostEntity getCostById(@PathVariable int
	 * costId) {
	 * 
	 * return costService.getCostById(costId); }
	 * 
	 * @DeleteMapping("/{id}") public void deleteCost(@PathVariable("id") int id) {
	 * costService.deleteCost(id); }
	 */

}
