package com.sukai.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sukai.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","admin");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }
}