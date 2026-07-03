package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String userEmail;
	Long foodId;
	String foodName;
	double price;
	int  quantity;
	String imageUrl;
	Cart(){}
	public Cart(Long id, String userEmail, Long foodId, String foodName, double price, int quantity) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
	}
	public Cart(String userEmail, Long foodId, String foodName, double price, int quantity) {
		super();
		this.userEmail = userEmail;
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
	

}
