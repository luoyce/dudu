package com.vincent.duduWeb.controller;

import com.vincent.duduPojo.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-customer.xml"});
        context.start();

        UserService demoService = (UserService) context.getBean("userRPCService");
        List<User> obs = demoService.getAll();

        return "index";
    }
}
