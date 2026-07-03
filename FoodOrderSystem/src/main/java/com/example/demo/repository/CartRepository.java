package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart>findByUserEmail(String userEmail);
	
	public void deleteByUserEmail(String userEmail);

}
