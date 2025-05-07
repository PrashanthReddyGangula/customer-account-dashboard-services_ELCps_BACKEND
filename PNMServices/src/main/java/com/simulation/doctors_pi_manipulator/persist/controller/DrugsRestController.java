package com.simulation.doctors_pi_manipulator.persist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.doctors_pi_manipulator.persist.entity.Drugs;
import com.simulation.doctors_pi_manipulator.persist.service.DrugsService;

@RestController
@RequestMapping("/products")
public class DrugsRestController {

	@Autowired
    private DrugsService productService;

    @PostMapping("/add")
    public ResponseEntity<Drugs> addProduct(@RequestBody Drugs product) {
    	Drugs savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
}
