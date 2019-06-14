package com.lick.service.impl;

import com.lick.domain.User;
import com.lick.mapper.UserMapper;
import com.lick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();

    }

    @Override
    public User findUserById(Integer userId) {

        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }
}
