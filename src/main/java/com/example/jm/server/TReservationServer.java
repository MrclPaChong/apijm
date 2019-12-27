package com.example.jm.server;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.utils.result.ResponseBean;


/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:38
 */
public interface TReservationServer {

    /**
     * 测试
     */
    JSONObject getByAll();

    /**
     * 预约提交上送
     */
    ResponseBean insertByReservation(JSONObject jsonObject);
}
