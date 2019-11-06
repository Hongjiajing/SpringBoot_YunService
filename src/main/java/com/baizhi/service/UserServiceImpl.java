package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Integer add(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        user.setStatus("正常");
        return userDAO.add(user);
    }

    @Override
    public Integer del(User user) {
        return userDAO.del(user.getId());
    }

    @Override
    public Integer edit(User user) {
        return userDAO.edit(user);
    }

    @Override
    public Integer editStatus(User user) {

        if("正常".equals(user.getStatus())){
            user.setStatus("冻结");
        }else{
            user.setStatus("正常");
        }
        return userDAO.editStatus(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> queryAll(Integer page,Integer rows) {
        Integer pa = (page-1)*rows;
        return userDAO.queryAll(pa,rows);
    }

    @Override
    public Integer dataNums() {
        return userDAO.dataNums();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User login(User user) {
        User query = userDAO.query(user.getUsername());
        if(query==null)
            throw new RuntimeException("用户名输入错误");
        if(!user.getAge().equals(query.getAge()))
            throw new RuntimeException("密码输入错误");
        return query;
    }
}
