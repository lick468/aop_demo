package com.lick.service;

import com.lick.domain.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> findAllUser();
    User  findUserById(Integer userId);
    User  findUserByUsername(String username);
    int deleteUser(Integer userId);
}
