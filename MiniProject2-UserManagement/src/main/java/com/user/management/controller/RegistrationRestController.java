package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.model.User;
import com.user.management.service.IUserService;

@RestController
@RequestMapping("/user")
public class RegistrationRestController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		
		if(userService.registerUser(user)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
