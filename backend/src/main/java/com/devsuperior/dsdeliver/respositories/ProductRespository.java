package com.devsuperior.dsdeliver.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Product;

public interface ProductRespository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();

}
