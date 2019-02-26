package com.vincent.duduspringboot.controller;

import com.vincent.duduEntity.User;
import com.vincent.duduService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-02-16 20:57
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList", method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> userList(){
        ModelAndView modelAndView = new ModelAndView("user/userList");

        List<User> list = this.userService.getAll();

        return list;
    }
}
