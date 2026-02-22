package com.addy.ICart.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addy.ICart.Entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	public Optional<Order> findByOrderNo(String OrderNo);

}
