package com.addy.ICart.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.addy.ICart.Entities.ProductEntity;

public class ProductSpecification {
	
	public static Specification<ProductEntity> hasCategory(String category) {
		
		return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"), category);
		
	}
	
	public static Specification<ProductEntity> priceBetween(Double min, Double max){
		
		return (root, query, cb) -> {
			if(min == null && max == null) return null;
			if(min == null) return cb.lessThanOrEqualTo(root.get("price"), max);
			if(max == null) return cb.greaterThanOrEqualTo(root.get("price"), min);
			return cb.between(root.get("price"), min, max);
		};
		
	}
	
	public static Specification<ProductEntity> hasNameorDescriptionLike(String keyword){
		return (root, query, cb) -> {
			if(keyword == null || keyword.isEmpty() ) return null;
			return cb.or(
					cb.like(root.get("name"), "%" + keyword.toLowerCase() + "%"),
					cb.like(root.get("description"), "%" + keyword.toLowerCase() + "%")
					);
		};
	}

}
