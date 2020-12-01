package com.github.hyeyoom.springbootonintellij;

import com.github.hyeyoom.springbootonintellij.domain.User;
import com.github.hyeyoom.springbootonintellij.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootOnIntellijApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOnIntellijApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void test() {
        final User user = new User("Chiho Won", "a@b.com");
        userRepository.createUser(user);
    }
}
