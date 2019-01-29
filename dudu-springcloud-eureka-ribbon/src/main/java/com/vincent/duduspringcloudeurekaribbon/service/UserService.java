package com.vincent.duduspringcloudeurekaribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-01-28 23:03
 **/
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    public String get(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/user/get?name="+name,String.class);
    }
}
