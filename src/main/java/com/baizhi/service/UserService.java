package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    Integer add (User user);
    Integer del (User user);
    Integer edit (User user);
    Integer editStatus(User user);
    List<User> queryAll(Integer page,Integer rows);
    Integer dataNums();
    User login(User user);
}
