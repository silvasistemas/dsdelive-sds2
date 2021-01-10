package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.respositories.OrderRespository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespository respository;
	
	@Transactional
	public List<OrderDTO> findAll() {
		List<Order> list = respository.findOrderWithProducts();
		return list.stream()
				.map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
