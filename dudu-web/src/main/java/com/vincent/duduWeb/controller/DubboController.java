package com.vincent.duduWeb.controller;

import com.vincent.duduDubboRPC.UserRPCService;
import com.vincent.duduEntity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description: DubboDemo
 * @author: weijian.yan
 * @create: 2019-01-19 18:20
 **/

@Controller
@RequestMapping("/dubbo")
public class DubboController {
    @RequestMapping("/index")
    public ModelAndView index() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-customer.xml"});
        context.start();

        UserRPCService demoService = (UserRPCService) context.getBean("userRPCService");
        List<User> obs = demoService.getAll();

        ModelAndView modelAndView = new ModelAndView("home/index");
        modelAndView.addObject("list", obs);
        System.out.println("index");

        return modelAndView;
    }
}
