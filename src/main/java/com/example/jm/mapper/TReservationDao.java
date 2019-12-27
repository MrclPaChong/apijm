package com.example.jm.mapper;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:37
 */
public interface TReservationDao {


    /**
     * 测试
     */
    List<JSONObject> getByAll();

    /**
     * 预约提交上送
     */
    int insertByReservation(JSONObject jsonObject);
}
