package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Food;
import com.example.demo.service.FoodService;

@RestController
@CrossOrigin(origins = "*")


public class FoodController {
	@Autowired 
	FoodService foodService;
	
	@GetMapping("/foods")
	public List<Food> getAllFood(){
		return foodService.getAllFood();
	}
	
	@GetMapping("/foods/{id}")
	public Food getFoodById(@PathVariable("id")Long id) {
		return foodService.getFoodById(id);
	}
	@PostMapping("/foods")
	public String addFood(@RequestBody()Food food) {
		return foodService.addFood(food);
	}
	@PutMapping("/foods/{id}")
	public String updateFood(@RequestBody()Food food,@PathVariable("id")Long id) {
		return foodService.updateFood(food,id);
	}
	@DeleteMapping("/foods/{id}")
	public String deleteFood(@PathVariable("id")Long id) {
		return foodService.deleteFood(id);
	}

}
