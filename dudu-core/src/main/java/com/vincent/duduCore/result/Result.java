package com.vincent.duduCore.result;

import com.alibaba.fastjson.JSON;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(){
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message= resultCode.getMessage();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message= resultCode.getMessage();
        this.data=data;
    }




    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message= resultCode.getMessage();
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
