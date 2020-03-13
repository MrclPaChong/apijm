package com.example.jm.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.mapper.TAttendanceDao;
import com.example.jm.server.TAttendanceServer;
import com.example.jm.utils.result.ResponseBean;
import com.example.jm.utils.tools.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-14 17:29
 */
@Service
public class TAttendanceServerImpl implements TAttendanceServer {

    //注入dao
    @Autowired
    private TAttendanceDao tAttendanceDao;


    @Override
    public ResponseBean selectMonthByYearByMonthByDay(JSONObject jsonObject) {
        List<JSONObject> resultselectAll = tAttendanceDao.selectMonthByYearByMonthByDay(jsonObject);
        return new ResponseBean(400,"This operation is successful",resultselectAll);
    }

    @Override
    public ResponseBean selectByTA(JSONObject jsonObject) {
        //获取前端约定查询SQL字段
        String flag = jsonObject.getString("flag");
        if (StringTools.isNullOrEmpty(flag)){
            return new ResponseBean(400,"请检查判断字段[flag]未输入值或者值为空");
        }else if (flag.equals("0")){
            //flag为0查询所有
            List<JSONObject> resultselectAll =tAttendanceDao.selectAll(jsonObject);
            return new ResponseBean(100,"This operation is successful",resultselectAll);
        }else if (flag.equals("1")){
            List<JSONObject> resultselectToday = tAttendanceDao.selectToday(jsonObject);
            return new ResponseBean(100,"This operation is successful",resultselectToday);
        }else if (flag.equals("2")){
            List<JSONObject> resultselectMonth = tAttendanceDao.selectMonth(jsonObject);
            return new ResponseBean(100,"This operation is successful",resultselectMonth);
        }

         return new ResponseBean(400,"未知错误");
    }

    @Override
    public ResponseBean insertByTA(JSONObject jsonObject) {

        //生成UUID
        jsonObject.put("id", UUID.randomUUID().toString().replace("-", ""));
        int res = tAttendanceDao.insertByTA(jsonObject);

        return new ResponseBean(100,"添加成功",res);
    }
}
