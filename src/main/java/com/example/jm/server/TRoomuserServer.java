package com.example.jm.server;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.utils.result.ResponseBean;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-03 10:51
 */
public interface TRoomuserServer {

    //根据身份证号判断居民是否已经录入
    ResponseBean getByRoomuserExist(JSONObject jsonObject);

    //居民信息采集上送
    ResponseBean insertByRoomuser(JSONObject jsonObject);

    //修改
    ResponseBean UpdateByRoomuser(JSONObject jsonObject);

    //修改
    ResponseBean delByRoomuser(JSONObject jsonObject);
}
