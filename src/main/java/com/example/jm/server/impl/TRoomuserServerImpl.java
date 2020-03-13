package com.example.jm.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.mapper.TRoomuserDao;
import com.example.jm.server.TRoomuserServer;
import com.example.jm.utils.result.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-03 10:52
 */
@Service
public class TRoomuserServerImpl implements TRoomuserServer {

    //注入居民档案dao
    @Autowired
    private TRoomuserDao tRoomuserDao;



    @Override
    public ResponseBean getByRoomuserExist(JSONObject jsonObject) {

        List<JSONObject> getByRoomuserExist = tRoomuserDao.getByRoomuserExist(jsonObject);
        // JsonObject null 不是字符串  https://blog.csdn.net/m0_37619971/article/details/88423720
        if (getByRoomuserExist.size()>0 ){
            return new ResponseBean(100,"账号存在",getByRoomuserExist);
        }else
            return new ResponseBean(400,"账号不存在",getByRoomuserExist);
    }

    @Transactional
    @Override
    public ResponseBean insertByRoomuser(JSONObject jsonObject) {

        //查询提交居民档案是否已经存在
        List<JSONObject> getByRoomuserExist = tRoomuserDao.getByRoomuserExist2(jsonObject);
        //isEmpty判空 https://blog.csdn.net/csdnluolei/article/details/87278650
        if (getByRoomuserExist.size()== 0){
            jsonObject.put("IsHaveVehicle",Integer.valueOf(jsonObject.getString("IsHaveVehicle")));
            //序号
            jsonObject.put("ID", UUID.randomUUID().toString().replace("-", ""));
            //房屋编号
            jsonObject.put("RoomID", UUID.randomUUID().toString().replace("-", ""));
            //登记时间
            jsonObject.put("CheckInTime",new Date());
            //楼宇ID
            jsonObject.put("BuildingID", UUID.randomUUID().toString().replace("-", ""));
            int res = tRoomuserDao.insertByRoomuser(jsonObject);
            return new ResponseBean(100,"This operation is successful(录入成功)",res);
        }else

            return new ResponseBean(400,"提交数据已存在,请勿反复提交",jsonObject);
    }

    @Override
    public ResponseBean UpdateByRoomuser(JSONObject jsonObject) {

        int res = tRoomuserDao.UpdateByRoomuser(jsonObject);
        return new ResponseBean(100,"This operation is successful(更新成功)",res);
    }

    @Override
    public ResponseBean delByRoomuser(JSONObject jsonObject) {
        int res = tRoomuserDao.delByRoomuser(jsonObject);
        return new ResponseBean(100,"This operation is successful(删除成功)",res);
    }
}
