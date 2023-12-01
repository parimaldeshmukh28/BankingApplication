package com.softwarescope_technology.banking_application.services;

import org.springframework.http.ResponseEntity;

import com.softwarescope_technology.banking_application.model.UserInfo;

public interface UserService {

	public String registerUser(UserInfo userInfo);

	public ResponseEntity<UserInfo> loginUser(String userName, String password);

}
