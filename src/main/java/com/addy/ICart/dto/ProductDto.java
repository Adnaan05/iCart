package com.addy.ICart.dto;

import java.util.List;



public class ProductDto {
	
	
	private Long id;
	

	private String name;
	
	private String category;
	

	private Double price;

	private String description;

	private String seller;

	private Integer stock;
	
	private Integer numOfReviews = 0;
	private Double ratings = 0.0;
	

	private List<ProductImageDto> images;
	

	private List<ProductReviewDto> reviews;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getNumOfReviews() {
		return numOfReviews;
	}
	public void setNumOfReviews(Integer numOfReviews) {
		this.numOfReviews = numOfReviews;
	}
	
	
	public List<ProductReviewDto> getReviews() {
		return reviews;
	}
	public void setReviews(List<ProductReviewDto> reviews) {
		this.reviews = reviews;
	}
	

	
	public List<ProductImageDto> getImages() {
		return images;
	}
	public void setImages(List<ProductImageDto> images) {
		this.images = images;
	}
	
	
	
	public ProductDto(Long id, String name, String category, Double price, String description, Double ratings, String seller,
			Integer stock, Integer numOfReviews) {
		super();
		this.id = id;
		this.name = name;
		this.category =category; 
		this.price = price;
		this.description = description;
		this.ratings = ratings;
		this.seller = seller;
		this.stock = stock;
		this.numOfReviews = numOfReviews;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
