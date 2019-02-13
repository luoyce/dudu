package com.vincent.duduDubboProvider.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-01-17 17:20
 **/

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/index")
    public String index() {
//        try{
//            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-provider.xml"});
//            context.start();
//
//            Thread.sleep(1000*60*60);
//        }catch (Exception ex)
//        {}

        return "index";
    }
}
