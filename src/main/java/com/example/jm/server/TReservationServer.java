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
     * 用户根据身份证号查询预约活动
     */
    ResponseBean getTReservationByUserCardNumber(JSONObject jsonObject);

    /**
     * 预约提交上送
     */
    ResponseBean insertByReservation(JSONObject jsonObject);

    /**
     * 根据ID删除已预约的活动
     */
    ResponseBean deleteReservationById(JSONObject jsonObject);
}
