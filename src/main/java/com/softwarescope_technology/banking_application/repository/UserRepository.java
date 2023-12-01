package com.softwarescope_technology.banking_application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarescope_technology.banking_application.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {

	public Optional<UserInfo> findByUserNameAndPassword(String userName, String password);

}
