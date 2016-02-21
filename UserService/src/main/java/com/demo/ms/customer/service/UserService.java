package com.demo.ms.customer.service;

import com.demo.ms.customer.dao.UserDao;
import com.demo.ms.customer.domain.User;
import com.demo.ms.customer.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public User findByUserId(final Long userId) {
        return dao.findOne(userId);
    }

    public User save(final User user) {
        return dao.save(user);
    }

    public User update(final long userId, final User user) {
        User currentUser = dao.findOne(userId);
        if (currentUser == null) {
            throw new NotFoundException();
        }
        if (user.getCity() != null) {
            currentUser.setCity(user.getCity());
        }
        if (user.getState() != null) {
            currentUser.setState(user.getState());
        }
        if (user.getGender() != null) {
            currentUser.setGender(user.getGender());
        }
        if (user.getName() != null) {
            currentUser.setName(user.getName());
        }
        if (user.getUserName() != null) {
            currentUser.setUserName(user.getUserName());
        }

        return dao.save(currentUser);
    }
}
