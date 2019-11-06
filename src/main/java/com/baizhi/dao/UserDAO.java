package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    Integer add (User user);//增
    Integer del (String id);//删
    Integer edit (User user);//改
    Integer editStatus(User user);//修改用户状态
    List<User> queryAll(@Param("page") Integer page,@Param("rows") Integer rows);//分页查询所有数据
    Integer dataNums();//所有数据总数
    User query(String username);//用户名查询
}
