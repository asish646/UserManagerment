package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.service.IUserService;

@RestController
@RequestMapping("/unlock")
public class UnlockAccountRestController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/checkTemp")
	public ResponseEntity<String> isTempPwdCorrect(@RequestParam String email, @RequestParam String tempPwd){
	
		if(userService.isTempPwdValid(email, tempPwd)) {
			return new ResponseEntity<String>("VALID", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("INVALID", HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> unlockAccount(@RequestParam String email, @RequestParam String newPassword){
		
		if(userService.unlockUser(email, newPassword)) {
			return new ResponseEntity<String>("VALID", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
