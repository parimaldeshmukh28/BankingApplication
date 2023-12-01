package com.softwarescope_technology.banking_application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;

	
	@NotEmpty
	@Size(min = 2, message = "user firstname should have at least 2 characters")
	private String firstName;

	@NotEmpty
	@Size(min = 2, message = "user firstname should have at least 2 characters")
	private String lastName;

	@NotBlank
	@Size(min = 10, max = 10, message = "mobile no should be 10 digits")
	private String mobileNumber;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String userName;

	@NotBlank
	@Size(min = 8, message = "password should contain at least 8 chacters")
	private String password;

	@NotBlank
	@Size(min = 8, message = "password should contain at least 8 chacters")

	private String confirmPassword;

	private String gender;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmial(String emial) {
		this.email = emial;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", gender=" + gender + "]";
	}

}
