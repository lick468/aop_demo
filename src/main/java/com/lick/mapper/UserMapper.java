package com.lick.mapper;

import com.lick.domain.User;

import java.util.List;


public interface UserMapper  {

    int insertUser(User user);
    List<User> findAllUser();
    User  findUserById(Integer userId);
    User  findUserByUsername(String username);
    int deleteUser(Integer userId);

}