package com.vincent.duduDao.dao;

import com.vincent.duduEntity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Mapper
@Repository
public interface UserDao {
    @Select("SELECT * FROM [USER]")
    List<User> getAll();

    @Select("INSERT INTO user(code, name, age) VALUES(#{code},#{name}, #{age})")
    void add(User user);

    @Update("UPDATE user SET age=#{age},name=#{name} WHERE code=#{code}")
    void update(User user);

    @Delete("DELETE FROM user WHERE code =#{code}")
    void delete(String code);
}
