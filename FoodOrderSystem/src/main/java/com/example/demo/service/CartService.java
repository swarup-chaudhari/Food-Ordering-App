package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Food;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.FoodRepository;

@Service
public class CartService {
	@Autowired
	FoodRepository foodRepository;
	@Autowired
	CartRepository cartRepository;
	
	
	public Cart addToCart(Cart cart) {

	    // 🔥 Get food from DB
	    Food food = foodRepository.findById(cart.getFoodId()).orElse(null);

	    if (food != null) {
	        cart.setFoodName(food.getName());
	        cart.setPrice(food.getPrice());

	        // ✅ ADD THIS (main fix)
	        cart.setImageUrl(food.getImageUrl());
	    }

	    List<Cart> existingCart = cartRepository.findByUserEmail(cart.getUserEmail());

	    for (Cart items : existingCart) {
	        if (items.getFoodId().equals(cart.getFoodId())) {
	            items.setQuantity(items.getQuantity() + cart.getQuantity());
	            return cartRepository.save(items);
	        }
	    }

	    return cartRepository.save(cart);
	}

	public List<Cart> getCartByUser(String email) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserEmail(email);
	}
	
	public void clearCart(Long id) {
		cartRepository.deleteById(id);
	}

}
