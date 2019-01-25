package com.vincent.duduDao.dao;

import com.vincent.duduEntity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("SELECT * FROM USER")
    public List<User> getAll();

    @Select("INSERT INTO user(code, name, age) VALUES(#{code},#{name}, #{age})")
    public void add(User user);

    @Update("UPDATE user SET age=#{age},name=#{name} WHERE code=#{code}")
    public void update(User user);

    @Delete("DELETE FROM user WHERE code =#{code}")
    public void delete(String code);
}
