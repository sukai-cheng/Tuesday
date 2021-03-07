package com.sukai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengsukai
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello springboot!!!");
        return "hello springboot";
    }
}
