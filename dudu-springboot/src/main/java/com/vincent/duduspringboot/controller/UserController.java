package com.vincent.duduspringboot.controller;

import com.vincent.duduCore.result.Result;
import com.vincent.duduCore.result.ResultGenerator;
import com.vincent.duduEntity.User;
import com.vincent.duduService.DataPushService;
import com.vincent.duduService.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private DataPushService dataPushService;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/userList", method = {RequestMethod.POST,RequestMethod.GET})
    public Result<List<User>> userList(){
        ModelAndView modelAndView = new ModelAndView("user/userList");

        dataPushService.push();
        List<User> list = this.userService.getAll();

        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value="我只是个简单的例子", notes="")
    @ApiImplicitParam(name = "param", value = "参数", required = true, dataType = "Long")
    @RequestMapping(value = "/simple", method = {RequestMethod.POST,RequestMethod.GET})
    public String simple(Long param){

        return "Simple";
    }
}
