package com.vincent.duduService.impl;

import com.alibaba.fastjson.JSONArray;
import com.vincent.duduCore.handler.MultiResultHandler;
import com.vincent.duduCore.model.MultiResultSetIModel;
import com.vincent.duduDao.dao.ProDao;
import com.vincent.duduEntity.User;
import com.vincent.duduService.DataPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: weijian.yan
 * @create: 2019-03-19 12:51
 **/
@Service
public class DataPushServiceImpl implements DataPushService {
    @Autowired
    private ProDao proDao;

    public void push(){
        List<MultiResultSetIModel> obs1 =proDao.getCDCgetDataChange();
        MultiResultHandler resultHandler = new MultiResultHandler();

        proDao.getCDCgetDataChange2(resultHandler);
        List<MultiResultSetIModel> obs = resultHandler.getObs();

        JSONArray j = null;
//        for (MultiResultSetIModel map: obs1) {
//            if (map.getDataType() == 1){
//                //return (List<User>)map.getData();
//            }else {
//                j=(JSONArray)map.getData();
//            }
//        }
    }
}
