package com.vincent.duduDao.dao;

import com.vincent.duduCore.handler.MultiResultHandler;
import com.vincent.duduCore.model.MultiResultSetIModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description: 存储过程
 * @author: weijian.yan
 * @create: 2019-03-15 12:03
 **/
@Component
@Mapper
@Repository
public interface ProDao {
    @Select({ "EXEC SP_CDC_GET_DATA_CHANGE" })
    @Options(statementType= StatementType.CALLABLE)
    List<MultiResultSetIModel> getCDCgetDataChange();

    @ResultType(value= Map.class)
    @Result()
    @Select({ "EXEC SP_CDC_GET_DATA_CHANGE" })
    @Options(statementType= StatementType.CALLABLE)
    void getCDCgetDataChange2(MultiResultHandler resultHandler);
}
