package com.example.jm.mapper;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-14 17:14
 */
public interface TAttendanceDao {

    /**
     *  查询所有
     */
    List<JSONObject> selectAll(JSONObject jsonObject);

    /**
     *   //查询当天
     */

    List<JSONObject> selectToday(JSONObject jsonObject);

    /**
     *   //查询本月
     */

    List<JSONObject> selectMonth(JSONObject jsonObject);


    /**
     *  根据年、月、天查询月数据
     */
    List<JSONObject> selectMonthByYearByMonthByDay(JSONObject jsonObject);
    /**
     *  新增
     */
    int insertByTA(JSONObject jsonObject);
}
