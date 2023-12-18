package com.sprint.saleshistory.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.models.AuthPojo;
import com.sprint.saleshistory.models.UserPojo;
import com.sprint.saleshistory.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/login")
	public AuthPojo authenticateUser(@RequestBody UserPojo userPojo) {
		return userService.authenticateUser(userPojo);
	}

}
