package com.github.hyeyoom.domain;

import java.time.LocalDateTime;

public class User {
	
	private Long id;
	private String email;
	private String password;
	private LocalDateTime joinedDate;
	
	public User(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDateTime joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", joinedDate=" + joinedDate + "]";
	}
	
}
