package com.addy.ICart.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addy.ICart.Entities.Order;
import com.addy.ICart.Entities.OrderItem;
import com.addy.ICart.Entities.ProductEntity;
import com.addy.ICart.Repositories.OrderRepository;
import com.addy.ICart.Repositories.ProductRepository;
import com.addy.ICart.dto.CreateOrderRequest;
import com.addy.ICart.dto.OrderItemDto;


@Service
public class OrderService {
	
	@Autowired
	private ProductRepository productRep;
	
	@Autowired 
	private OrderRepository orderRep;
	
	public Order createOrder(CreateOrderRequest createOrderRequest){
		
		Order order = new Order();
		order.setStatus("PENDING");
		double totalItemsAmount = 0;
		double totalAmount = 0;
		double taxAmount = 10;
		
		for(OrderItemDto item : createOrderRequest.getOrderItems() ) {
			
			OrderItem orderItem = new OrderItem();
			orderItem.setName(item.getName() );
			orderItem.setImage(item.getImage() );
			orderItem.setPrice(item.getPrice() );
			orderItem.setQuantity(item.getQuantity() );
			ProductEntity product = productRep.findById(item.getProductId() ).orElseThrow(() -> new RuntimeException("User not found with the provided Id") );
			orderItem.setProduct(product);
			
			totalItemsAmount += item.getPrice() * item.getQuantity();
			
			
			order.getOrderItems().add(orderItem);
			
		}
		order.setTotalItemsAmount(totalItemsAmount);
		
		totalAmount = totalItemsAmount + taxAmount;
		order.setTotalAmount(totalAmount);
		order.setOrderNo(UUID.randomUUID().toString() );
		
		return orderRep.save(order);
		
	}
	
	
	public Order getOrderByOrderNo(String OrderNo){
		return orderRep.findByOrderNo(OrderNo).orElseThrow( () -> new RuntimeException("Order Not found with the provided Order Number."));
	}

}
