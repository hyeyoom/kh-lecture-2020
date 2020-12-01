package com.github.hyeyoom.springbootonintellij.repository;

import com.github.hyeyoom.springbootonintellij.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    int createUser(User user);
}
