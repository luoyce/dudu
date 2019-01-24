package com.vincent.duduDubboRPC;

import com.vincent.duduPojo.User;

import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-01-19 23:01
 **/
public interface UserRPCService {
    public List<User> getAll();
}
