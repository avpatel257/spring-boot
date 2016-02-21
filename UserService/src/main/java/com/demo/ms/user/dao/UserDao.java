package com.demo.ms.user.dao;

import com.demo.ms.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {
}