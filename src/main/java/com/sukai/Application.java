package com.sukai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author chengsukai
 * @desc springboot入口文件
 */
@MapperScan("com.sukai.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // springApplication: spring应用类    作用: 用来启动springboot应用
        // 参数1: 传入入口类 类对象   参数2: main函数的参数
        SpringApplication.run(Application.class, args);
    }
}
