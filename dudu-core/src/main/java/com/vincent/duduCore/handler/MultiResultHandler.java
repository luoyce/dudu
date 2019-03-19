package com.vincent.duduCore.handler;

import com.vincent.duduCore.model.MultiResultSetIModel;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-03-19 09:36
 **/
public class MultiResultHandler implements ResultHandler {
    List<MultiResultSetIModel> obs = null;

    public List<MultiResultSetIModel> getObs() {
        return obs;
    }

    public void handleResult(ResultContext resultContext) {
        Object obj = resultContext.getResultObject();
        obs = null;
    }
}
