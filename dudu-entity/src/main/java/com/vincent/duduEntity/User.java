package com.vincent.duduEntity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {
    public User(){
    }

    public User(String _name){
        name=_name;
    }

    @NotBlank(message = "编号不能为空")
    private String code;
    @NotBlank(message = "用户名不能为空")
    @Length(min = 2, max = 16, message = "用户名的长度必须在2~16位之间")
    private String name;
    @Range(min = 18, max = 60, message = "年龄必须在18岁到60岁之间")
    private int age;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
