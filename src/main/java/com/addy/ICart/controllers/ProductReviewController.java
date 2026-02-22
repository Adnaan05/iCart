package com.addy.ICart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addy.ICart.Services.ProductService;
import com.addy.ICart.dto.ProductReviewDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products/review")
public class ProductReviewController {
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<?> addReview(@RequestBody @Valid ProductReviewDto reviewDto){
		
		productService.addReview(reviewDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added Review");
		
		
	}

}
