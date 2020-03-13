package com.example.jm.mapper;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-03 9:27
 */
public interface TRoomuserDao {

    //网格员身份效验
    List<JSONObject> getByRoomuserExist(JSONObject jsonObject);

    //根据身份证号判断居民是否已经录入
    List<JSONObject> getByRoomuserExist2(JSONObject jsonObject);
    //居民信息采集上送
    int insertByRoomuser(JSONObject jsonObject);

    //修改
    int UpdateByRoomuser(JSONObject jsonObject);

    //删除
    int delByRoomuser(JSONObject jsonObject);
}
