package com.vincent.duduService.impl;


import com.vincent.duduDao.dao.UserDao;
import com.vincent.duduDubboRPC.UserRPCService;
import com.vincent.duduPojo.User;
import com.vincent.duduService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserRPCService,UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll(){
        return  userDao.getAll();
        //return  null;
    }

    public void add(User user){

        userDao.add(user);
    }

    public void update(User user){
         
        userDao.update(user);
    }

    public void delete(String code){
         userDao.delete(code);
    }
}
