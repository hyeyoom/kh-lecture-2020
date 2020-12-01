package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;

@RestController
@RequestMapping("/users")
public class UserAPIController {
	
	// /users/550e8400-e29b-41d4-a716–446655440000	
	@GetMapping("/{userId}")
	public String getUserInfo(@PathVariable String userId) {
		System.out.println(userId);
		return "안녕";
	}
	
	@GetMapping
	public String getgetget(@RequestParam("key") String value) {
		System.out.println(value);
		return "ㅃ";
	}
	
	// "{"name":"Chiho Won","email":"high.neoul@gmail.com"}"
	@PostMapping
	public Message postpost(@RequestBody User user) {
		return new Message("어 안녕!");
	}
}
