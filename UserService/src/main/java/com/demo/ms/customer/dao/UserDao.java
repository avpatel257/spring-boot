package com.demo.ms.customer.dao;

import com.demo.ms.customer.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Long> {
}