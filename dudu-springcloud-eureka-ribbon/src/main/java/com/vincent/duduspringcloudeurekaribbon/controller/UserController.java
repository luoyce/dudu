package com.vincent.duduspringcloudeurekaribbon.controller;

import com.vincent.duduspringcloudeurekaribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-01-28 23:08
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/get")
    public String get(@RequestParam String name) {
        return userService.get( name );
    }
}
