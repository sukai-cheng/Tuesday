package com.sukai.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sukai.mapper.UserMapper;
import com.sukai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 判断username是否存在
     * @param username
     * @return
     */
    public boolean isExist(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        return null != user;
    }

    /**
     * 通过名字找账户
     * @param username
     * @return
     */
    public User getByName(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 通过传来的username和password找到账户
     * @param username
     * @param password
     * @return
     */
    public User get(String username, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",password);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 将传来的user保存到数据库中
     * @param user
     */
    public void add(User user){
        userMapper.insert(user);
    }

}
