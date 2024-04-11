package com.ee417.website.group.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ee417.website.group.models.User;
import com.ee417.website.group.service.RoleService;
import com.ee417.website.group.service.UserService;

/*
 * Based on example given in lectures for linking front-end to db with hybernate
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // Allows requests from other domains. Adjust or remove based on security requirements.
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> listUsers() {
		System.out.println("GET request received for user controller.");
		return ResponseEntity.ok(userService.listUsers());
	}
	
	// url = http:localhost:8080/user/new
	@PostMapping("/new")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		userService.addUser(user);
		System.out.println("POST request '/new' received for user controller.");
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}
}
