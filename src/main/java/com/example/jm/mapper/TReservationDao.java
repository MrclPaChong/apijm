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
     * 用户根据身份证号查询预约活动
     */
    List<JSONObject> getTReservationByUserCardNumber(JSONObject jsonObject);


    /**
     *  效验已经预约的活动不能再预约
     */
    List<JSONObject> getReservationId(JSONObject jsonObject);
    /**
     * 预约提交上送
     */
    int insertByReservation(JSONObject jsonObject);


    /**
     * 根据ID删除已预约的活动
     */
    int deleteReservationById(JSONObject jsonObject);
}
