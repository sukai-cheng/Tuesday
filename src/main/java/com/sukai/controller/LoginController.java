package com.sukai.controller;

import com.sukai.pojo.User;
import com.sukai.result.Result;
import com.sukai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @author chengsukai
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());

        if (null == user) {
            return new Result(400);
        } else {
            /* 用户在应用程序之间跳转session对象的变量不会丢失 */
            session.setAttribute("user", user);

            return new Result(200);
        }
    }

}