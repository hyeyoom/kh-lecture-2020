package com.example.demo.domain;

import java.time.LocalDateTime;

public class Message {
	private String message;
	private LocalDateTime responseDate;
	
	public Message() {
		
	}
	
	public Message(String message) {
		this.message = message;
		this.responseDate = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getResponseDate() {
		return responseDate;
	}
	
	public void setResponseDate(LocalDateTime responseDate) {
		this.responseDate = responseDate;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", responseDate=" + responseDate + "]";
	}
}
