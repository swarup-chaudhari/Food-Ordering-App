package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	List<User>users;
	@Autowired
	UserRepository userRepository;
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "User Added Successfully";
	}
	public String updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		User existing=userRepository.findById(id).orElse(null);
		
		if(existing==null) {
			return "User Not Found";
		}
		
		existing.setName(user.getName());
		existing.setEmail(user.getEmail());
		existing.setPassword(user.getPassword());
		return "Updated Successfully";
	}
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
