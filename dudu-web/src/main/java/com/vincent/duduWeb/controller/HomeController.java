package com.vincent.duduWeb.controller;

import com.vincent.duduCore.annotation.ControllerException;
import com.vincent.duduCore.interceptor.ErrorInterceptor;
import com.vincent.duduEntity.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/*
* @Description:  modelAndView间传值，页面间传值
* @Author: weijian.yan
* @Date: 2019/1/6
*/
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @ControllerException(ErrorInterceptor.class)
    @RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
    public  ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("home/index");

        List<User> list = this.userService.getAll();

        modelAndView.addObject("list", list);
        System.out.println("index");

        return modelAndView;
    }

    @RequestMapping(value = "/paramByServletRequest", method = {RequestMethod.POST,RequestMethod.GET})
    public String paramByServletRequest(HttpServletRequest request) {
        String paramByServletRequest = request.getParameter("paramByServletRequest");
        return  "home/index";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView add(User user) {
        ModelAndView modelAndView = new ModelAndView("home/index");

        userService.add(user);

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView update(User user) {
        ModelAndView modelAndView = new ModelAndView("home/index");

        userService.update(user);

        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView delete(String code) {
        ModelAndView modelAndView = new ModelAndView("home/index");

        userService.delete(code);

        return modelAndView;
    }

    @RequestMapping(value = "/paramByJson", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView paramByJson(@RequestBody User user) {
        ModelAndView modelAndView = new ModelAndView("home/index");
        List<User> list = new ArrayList<User>();
        list.add(user);
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping(value = "/paramByMap", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView paramByMap(@RequestBody Map<String, String> map) {
        ModelAndView modelAndView = new ModelAndView("home/index");

        modelAndView.addObject("mapKey", map.get("mapKey"));

        return modelAndView;
    }

    //RedirectView view = new RedirectView("regirst.do");  视图重定向
}