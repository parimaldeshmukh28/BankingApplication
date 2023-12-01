package com.softwarescope_technology.banking_application.services;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softwarescope_technology.banking_application.model.UserInfo;
import com.softwarescope_technology.banking_application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String registerUser(UserInfo userInfo) {
		try {
			userRepository.save(userInfo);
			return "saved user information successfully";
		} catch (Exception e) {
			logger.info("Exception occurd while stoaring the user information " + e.getMessage());
			throw e;
		}

	}

	@Override
	public ResponseEntity<UserInfo> loginUser(String userName, String password) {
		try {
			Optional<UserInfo> user = userRepository.findByUserNameAndPassword(userName, password);
			if (user.isPresent() && user.get().getUserName().equals(userName)
					&& user.get().getPassword().contains(password)) {

				logger.info("user logged in successfully UserName :{},password :{}", userName,password);
				return ResponseEntity.ok(user.get());
			} else {
				logger.info("Invalid username and password UserName :{},password :{}", userName,password);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			logger.error("Invalid userId and Password: " + e.getMessage());
			throw e;
		}
	}
}
