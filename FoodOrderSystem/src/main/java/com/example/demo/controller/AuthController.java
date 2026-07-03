package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	JwtUtil jwtUtil=new JwtUtil();
	
	@PostMapping("/login")
	public String login(@RequestBody()User user) {
		User dbUser=userRepository.findAll()
				.stream()
				.filter(u->u.getEmail().equals(user.getEmail())
						&& u.getPassword().equals(user.getPassword())).findFirst()
				.orElse(null);
		if (dbUser==null) {
			return "Invalid Login Credentials";
			
		}
		return jwtUtil.generateToken(dbUser.getEmail());
	}

}
