package com.addy.ICart.Services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.addy.ICart.Entities.ProductEntity;
import com.addy.ICart.Entities.ProductReview;
import com.addy.ICart.Repositories.ProductRepository;
import com.addy.ICart.Repositories.ProductReviewRepository;
import com.addy.ICart.dto.ProductDto;
import com.addy.ICart.dto.ProductImageDto;
import com.addy.ICart.dto.ProductReviewDto;
import com.addy.ICart.specifications.ProductSpecification;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductReviewRepository productReviewRepository;
	
	public Map<String, Object> getAllProducts(int page, int size){
		
		Pageable pageable = PageRequest.of(page, size);
		Page<ProductEntity> products = productRepository.findAll(pageable);
		
		
		List<ProductDto> productDtos = products.stream().map( this::convertToDto ).collect(Collectors.toList() );
		
		
		Map<String, Object> response = new HashMap<>();
		response.put("products", productDtos );
		response.put("TotalProducts", products.getTotalElements() );
		return response;
		
	}
	
	public ProductDto convertToDto(ProductEntity product) {
		
		ProductDto productDto = new ProductDto();
		
		
		productDto.setId(product.getId() );
		productDto.setName(product.getName() );
		productDto.setCategory(product.getCategory() );
		productDto.setPrice(product.getPrice() );
		productDto.setDescription(product.getDescription() );
		productDto.setRatings(product.getRatings() );
		productDto.setSeller(product.getSeller() );
		productDto.setStock(product.getStock() );
		productDto.setNumOfReviews(product.getNumOfReviews() );
		
		
		
		List<ProductReviewDto> reviewDtos = product.getReviews().stream().map(
				review -> {
					ProductReviewDto reviewDto = new ProductReviewDto();
					reviewDto.setId(review.getId() );
					reviewDto.setComment(review.getComment() );
					reviewDto.setRatings(review.getRating() );
					return reviewDto;
				}
				).collect(Collectors.toList() );
		
		productDto.setReviews(reviewDtos);
		
		
		
		List<ProductImageDto> ImageDtos = product.getImages().stream().map(
				image -> {
					ProductImageDto imageDto = new ProductImageDto(image.getPublicId() );
					
					return imageDto;
				}
				).collect(Collectors.toList() );
		
		productDto.setImages(ImageDtos);
		
		return productDto;
		
	}
	
	public ProductEntity getProductById(long id) {
		return productRepository.findById(id).orElseThrow( () -> new RuntimeException("Product not found") );
	}
	
	public List<ProductEntity> searchProducts(String category, Double minPrice, Double maxPrice, String keyword ) {
		
		Specification<ProductEntity> spec = ProductSpecification.hasCategory(category)
				.and(ProductSpecification.priceBetween(minPrice, maxPrice) )
				.and(ProductSpecification.hasNameorDescriptionLike(keyword) );
		return productRepository.findAll(spec);
		
	}

	public void addReview(ProductReviewDto reviewDto) {
		// TODO Auto-generated method stub
		ProductEntity product = productRepository.findById(reviewDto.getId() ).orElseThrow( () -> new RuntimeException("Id not found")); 
		ProductReview review = new ProductReview();
		
		review.setComment(reviewDto.getComment() );
		review.setRating(reviewDto.getRatings() );
		review.setProduct(product);
		productReviewRepository.save(review);
		
	}

}
