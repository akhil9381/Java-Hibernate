package com.cvr.userdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody User user) {
		userService.save(user);
	}
	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable int id) {
		return userService.find(id);
	}
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
}
