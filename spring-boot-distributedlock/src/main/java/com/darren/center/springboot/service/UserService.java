package com.darren.center.springboot.service;

import com.darren.center.springboot.entity.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Long id);


    List<User> selectUserList();

    int editUserById(User user);

    int deleteUserById(Long id);

    int addUser(User user);

}
