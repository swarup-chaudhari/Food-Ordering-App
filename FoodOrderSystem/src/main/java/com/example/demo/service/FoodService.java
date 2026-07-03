package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Food;
import com.example.demo.repository.FoodRepository;

@Service
public class FoodService {
	List<Food>foods;
	@Autowired
	FoodRepository foodRepository;

	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return foodRepository.findAll();
	}

	public Food getFoodById(Long id) {
		// TODO Auto-generated method stub
		return foodRepository.findById(id).orElse(null);
	}

	public String addFood(Food food) {
		// TODO Auto-generated method stub
		 foodRepository.save(food);
		 return "Food Added Successfully";
	}

	public String updateFood(Food food, Long id) {
		// TODO Auto-generated method stub
		Food existing=foodRepository.findById(id).orElse(null);
		if(existing==null) {
			return "Food Not Found";
		}
		existing.setName(food.getName());
		existing.setPrice(food.getPrice());
		existing.setImageUrl(food.getImageUrl());
		return "Updated Successfully";
	}

	public String deleteFood(Long id) {
		foodRepository.deleteById(id);
		return "Food Deleted Successfully";
		
	
	}

}
