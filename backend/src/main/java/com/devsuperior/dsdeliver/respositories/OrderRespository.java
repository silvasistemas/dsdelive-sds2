package com.devsuperior.dsdeliver.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRespository extends JpaRepository<Order, Long>{

}
