package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.respositories.OrderRespository;
import com.devsuperior.dsdeliver.respositories.ProductRespository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespository respository;
	
	@Autowired
	private ProductRespository  productRespository;
	
	@Transactional
	public List<OrderDTO> findAll() {
		List<Order> list = respository.findOrderWithProducts();
		return list.stream()
				.map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), 
				dto.getLatitude(), dto.getLongitude(), Instant.now(),
		OrderStatus.PENDING);
		
		for(ProductDTO p: dto.getProducts()) {
			Product product = productRespository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = respository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = respository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = respository.save(order);
		return new OrderDTO(order);
		
	}
	

}
