package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cart;
import com.example.demo.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/add")
	public Cart addToCart(@RequestBody()Cart cart) {
		return cartService.addToCart(cart);
	}
	
	@GetMapping("/{email}")
	public List<Cart> getCart(@PathVariable("email")String email){
		return cartService.getCartByUser(email);
	}
	
	@DeleteMapping("/item/{id}")
	public void clearCart(@PathVariable("id")Long id) {
		cartService.clearCart(id);
	}

}
