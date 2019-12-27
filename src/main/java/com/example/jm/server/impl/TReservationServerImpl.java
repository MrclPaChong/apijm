package com.example.jm.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.mapper.TReservationDao;
import com.example.jm.server.TReservationServer;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:38
 */
@Service
public class TReservationServerImpl implements TReservationServer {

    //注入Dao
    @Autowired
    private TReservationDao tReservationDao;

    @Override
    public JSONObject getByAll() {
        List<JSONObject> tReservation = tReservationDao.getByAll();
        return ResponseBean.successJsonList(100,"This operation is successful",tReservation);
    }

    /**
     * 预约提交上送
     */
    @Override
    public ResponseBean insertByReservation(JSONObject jsonObject) {
        //UUID生成put进jsonObject作为id参数
        jsonObject.put("id",UUID.randomUUID().toString());
        int res = tReservationDao.insertByReservation(jsonObject);
        if (res==1){
            return new ResponseBean(100,"This operation is successful",res);
        }else
        return new ResponseBean(400,"This operation failed",res);
    }
}
