package com.doancuoiki.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.doancuoiki.demo.Entity.User;
import com.doancuoiki.demo.Repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/users")
public class UserController {
	private UserRepository userRepository;
	public UserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@GetMapping()
	public List<User> getAllOrder() {
		return this.userRepository.findAll();
	}
	@GetMapping("/{id}")
	public User getOrder(@PathVariable("id") String id) {
		Optional<User> user=this.userRepository.findById(id);
		return user.get();
	}

	@PostMapping()
	public void insert(@RequestBody User user) {
		
		this.userRepository.insert(user);
	}
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id") String id) {
		this.userRepository.deleteById(id);
	}

}
