package com.addy.ICart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addy.ICart.Entities.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>{

}
