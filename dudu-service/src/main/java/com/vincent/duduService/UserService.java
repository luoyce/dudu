package com.vincent.duduService;


import com.vincent.duduEntity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public void add(User user);

    public void update(User user);

    public void delete(String code);
}
