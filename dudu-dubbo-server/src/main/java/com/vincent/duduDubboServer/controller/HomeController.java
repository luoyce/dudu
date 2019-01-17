package com.vincent.duduDubboServer.controller;

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
        return "Hello";
    }
}
