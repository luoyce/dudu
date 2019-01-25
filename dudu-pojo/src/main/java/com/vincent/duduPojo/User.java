package com.vincent.duduPojo;

import java.io.Serializable;

public class User implements Serializable {
    public User(){
    }

    public User(String _name){
        name=_name;
    }

    String code;
    String name;
    int age;

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
