package com.vincent.duduWeb.controller;

import com.vincent.duduCore.annotation.ControllerException;
import com.vincent.duduEntity.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-02-14 09:58
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //@ControllerException(ErrorInterceptor.class)
    @RequestMapping(value = "/userList", method = {RequestMethod.POST,RequestMethod.GET})
    public  ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView("user/userList");

        List<User> list = this.userService.getAll();

        modelAndView.addObject("list", list);
        System.out.println("index");

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView add(@Valid @ModelAttribute("user") User user, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("user/userList");

        userService.add(user);

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView update(@Valid @ModelAttribute("user") User user, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("user/userList");

        userService.update(user);

        return modelAndView;
    }

    @RequestMapping(value = "/addOrUpdate", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView addOrUpdate(@Valid @ModelAttribute("user") User user, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("user/userList");
        if(user.getCode()==null||user.getCode()==""){
            userService.add(user);
        }else {
            userService.update(user);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView delete(String code) {
        ModelAndView modelAndView = new ModelAndView("user/userList");

        userService.delete(code);

        return modelAndView;
    }
}
