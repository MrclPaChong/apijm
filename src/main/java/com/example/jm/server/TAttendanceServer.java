package com.example.jm.server;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.utils.result.ResponseBean;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-14 17:29
 */
public interface TAttendanceServer {

    /**
     *  查询考勤记录 所有和当天和当月
     */
    ResponseBean selectByTA(JSONObject jsonObject);


    /**
     *   根据年、月、天查询月数据
     */
    ResponseBean selectMonthByYearByMonthByDay(JSONObject jsonObject);
    /**
     *  新增
     */
    ResponseBean insertByTA(JSONObject jsonObject);
}
