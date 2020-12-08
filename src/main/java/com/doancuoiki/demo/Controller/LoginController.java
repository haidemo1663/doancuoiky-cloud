package com.doancuoiki.demo.Controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doancuoiki.demo.Entity.User;
import com.doancuoiki.demo.Repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping("/login")
public class LoginController {
	private UserRepository userRepository;
	public LoginController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@PostMapping
	public boolean login(String email, String password) {
		 Optional<User> user=this.userRepository.findById(email);
		 if(user.get().getPassword()!=password) return false;
		 return true;
	}
}
