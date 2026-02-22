package com.addy.ICart.dto;



import jakarta.validation.constraints.NotNull;

public class ProductReviewDto {
	
	
	@NotNull(message = "Product Id is required")
	private Long id;
	
	@NotNull(message = "Product Comment is required")
	private String comment;
	
	@NotNull(message = "Product Ratings is required")
	private Double ratings;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	
	

	
	
	public ProductReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
