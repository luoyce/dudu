package com.vincent.duduService.impl;


import com.alibaba.fastjson.JSONArray;
import com.vincent.duduCore.annotation.AnnotationSimple;
import com.vincent.duduCore.handler.MultiResultHandler;
import com.vincent.duduCore.model.MultiResultSetIModel;
//import com.vincent.duduDao.dao.ProDao;
import com.vincent.duduDao.dao.ProDao;
import com.vincent.duduDao.dao.UserDao;
import com.vincent.duduDubboRPC.UserRPCService;
import com.vincent.duduEntity.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @AnnotationSimple
    public List<User> getAll(){
       return  userDao.getAll();
    }

    public void add(User user){

        //userDao.add(user);
    }

    public void update(User user){

        //userDao.update(user);
    }

    public void delete(String code){
         //userDao.delete(code);
    }
}
