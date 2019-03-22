package com.vincent.duduCore.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.vincent.duduCore.model.MultiResultSetIModel;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-03-16 09:49
 **/
//@Component
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class MultiResultSetInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Statement statement = (Statement) invocation.getArgs()[0];

        if(isDeal(invocation)){
            return invocation.proceed();
        }

        List<MultiResultSetIModel> result = new ArrayList<MultiResultSetIModel>();
        do {
            MultiResultSetIModel ob = toMultiResultSet(statement);
            result.add(ob);
        } while (statement.getMoreResults());

        return result;
    }

    public  boolean isDeal(Invocation invocation)throws Throwable{
        DefaultResultSetHandler hhh =(DefaultResultSetHandler)invocation.getTarget();
        Field field = DefaultResultSetHandler.class.getDeclaredField("mappedStatement");
        field.setAccessible(true);
        MappedStatement mm = (MappedStatement)field.get(hhh);
        String id =mm.getId();

        return !id.equals("com.vincent.duduDao.dao.ProDao.getCDCgetDataChange");

    }

    public  MultiResultSetIModel toMultiResultSet(Statement statement) throws SQLException {
        ResultSet rs = statement.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();

        MultiResultSetIModel ob = new MultiResultSetIModel();
        ob.setClassName(getClassName (rsmd));

        Object obj = null;
        Class<?> type = getTypeByClassName(ob.getClassName());
        if (type != null){
            ob.setDataType(1);
            ob.setData(toBean(rs, type));
        }else {
            ob.setDataType(2);
            ob.setData(toJson(rs));
        }

        return  ob;
    }

    public Class<?> getTypeByClassName(String className){
        Class<?> type = null;
        try {
            type= Class.forName("com.vincent.duduEntity.User");
        }catch (Exception ex){

        }

        return type;
    }

    public String getClassName (ResultSetMetaData rsmd) throws SQLException {
        String columnName = null;
        int total_rows = rsmd.getColumnCount();

        for (int i = 0; i < total_rows; i++) {
            columnName = rsmd.getColumnLabel(i + 1);
            if (columnName.contains("TABLE_NAME_")){
                columnName = columnName.replace("TABLE_NAME_","");
                break;
            }
        }

        return  columnName;
    }

    public List<Object> toBean(ResultSet rs,Class<?> type) throws SQLException {
        BeanProcessor pro = new BeanProcessor();
        List<Object> obs =pro.toBeanList(rs,type);

        return obs;
    }

    public JSONArray toJson(ResultSet rs) throws SQLException {
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()){
            JSONObject obj = new JSONObject();
            getType(rs, rsmd, obj);

            jsonArray.add(obj);
        }

        return jsonArray;
    }

    private void getType(ResultSet rs, ResultSetMetaData rsmd, JSONObject obj) throws SQLException {
        int total_rows = rsmd.getColumnCount();
        for (int i = 0; i < total_rows; i++) {
            String columnName = rsmd.getColumnLabel(i + 1);
//            if (obj.has(columnName)) {
//                columnName += "1";
//            }
            try {
                switch (rsmd.getColumnType(i + 1)) {
                    case java.sql.Types.ARRAY:
                        obj.put(columnName, rs.getArray(columnName));
                        break;
                    case java.sql.Types.BIGINT:
                        obj.put(columnName, rs.getInt(columnName));
                        break;
                    case java.sql.Types.BOOLEAN:
                        obj.put(columnName, rs.getBoolean(columnName));
                        break;
                    case java.sql.Types.BLOB:
                        obj.put(columnName, rs.getBlob(columnName));
                        break;
                    case java.sql.Types.DOUBLE:
                        obj.put(columnName, rs.getDouble(columnName));
                        break;
                    case java.sql.Types.FLOAT:
                        obj.put(columnName, rs.getFloat(columnName));
                        break;
                    case java.sql.Types.INTEGER:
                        obj.put(columnName, rs.getInt(columnName));
                        break;
                    case java.sql.Types.NVARCHAR:
                        obj.put(columnName, rs.getNString(columnName));
                        break;
                    case java.sql.Types.VARCHAR:
                        obj.put(columnName, rs.getString(columnName));
                        break;
                    case java.sql.Types.TINYINT:
                        obj.put(columnName, rs.getInt(columnName));
                        break;
                    case java.sql.Types.SMALLINT:
                        obj.put(columnName, rs.getInt(columnName));
                        break;
                    case java.sql.Types.DATE:
                        obj.put(columnName, rs.getDate(columnName));
                        break;
                    case java.sql.Types.TIMESTAMP:
                        obj.put(columnName, rs.getTimestamp(columnName));
                        break;
                    default:
                        obj.put(columnName, rs.getObject(columnName));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

        System.out.println("setProperties");
    }
}

