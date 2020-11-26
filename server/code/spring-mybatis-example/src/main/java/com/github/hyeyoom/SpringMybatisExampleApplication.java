package com.github.hyeyoom;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.hyeyoom.domain.User;
import com.github.hyeyoom.repository.UserRepository;

@SpringBootApplication
public class SpringMybatisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisExampleApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public void test() {
		User user = new User();
		user.setId(1L);	// long._.;
		user.setEmail("test@test.com");
		user.setPassword("1234abcd");
		user.setJoinedDate(LocalDateTime.now());
		userRepository.createUser(user);
	}
}
