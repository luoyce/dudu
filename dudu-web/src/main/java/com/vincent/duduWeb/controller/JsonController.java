package com.vincent.duduWeb.controller;

import com.vincent.duduCore.result.Result;
import com.vincent.duduCore.result.ResultGenerator;
import com.vincent.duduEntity.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-02-17 14:50
 **/
@Controller
@RequestMapping("/json")
public class JsonController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/user")
    public Result<List<User>> listAllUsers() {
        List<User> users = userService.getAll();

        return ResultGenerator.genSuccessResult(users);
    }
}
