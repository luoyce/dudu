package com.vincent.duduCore.model;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-03-18 14:11
 **/
public class MultiResultSetIModel {
    private String className;
    private int dataType;
    private  Object data;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
