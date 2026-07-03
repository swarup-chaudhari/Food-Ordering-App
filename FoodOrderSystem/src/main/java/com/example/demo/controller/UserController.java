package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id")Long id) {
		return userService.getUserById(id);
	}
	@PostMapping("/users")
	public String addUser(@RequestBody()User user) {
		return userService.addUser(user);
	}
	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody()User user,@PathVariable("id") Long id) {
		return userService.updateUser(user,id);
	}
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}
	

}
