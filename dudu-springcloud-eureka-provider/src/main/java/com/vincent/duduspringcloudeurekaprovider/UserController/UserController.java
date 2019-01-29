package com.vincent.duduspringcloudeurekaprovider.UserController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-01-28 22:21
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get")
    public String get(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name;
    }
}
