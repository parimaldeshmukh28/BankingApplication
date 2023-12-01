package com.softwarescope_technology.banking_application.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softwarescope_technology.banking_application.model.UserInfo;
import com.softwarescope_technology.banking_application.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@PostMapping
	public String registerUser(@RequestBody UserInfo userInfo) {

		try {
			logger.info("Request recieved for user registration :{}", userInfo);
			userServiceImpl.registerUser(userInfo);
			logger.info("Request processed for user registration :{}", userInfo);

		} catch (Exception e) {
			logger.error("error processing add userInfo request : ", e.getMessage());
		}
		return "user added successfully";
	}

	@GetMapping
	public ResponseEntity<UserInfo> getUserByuserNameAndPassword(@RequestParam String userName,
			@RequestParam String password) {
		try {

			logger.info("request recived for getUser by username And password :{}", userName, password);
			ResponseEntity<UserInfo> responseEntity = userServiceImpl.loginUser(userName, password);
			logger.info("request processed and user logged in successfully");
			return responseEntity;
		} catch (Exception e) {
			logger.error("error occured while user login ", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
