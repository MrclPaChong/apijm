package com.example.jm.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.mapper.TReservationDao;
import com.example.jm.server.TReservationServer;
import com.example.jm.utils.result.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:38
 */
@Service
public class TReservationServerImpl implements TReservationServer {

    //注入Dao
    @Autowired
    private TReservationDao tReservationDao;

    @Override
    public JSONObject getByAll() {
        List<JSONObject> tReservation = tReservationDao.getByAll();
        return ResponseBean.successJsonList(100,"This operation is successful",tReservation);
    }

    @Override
    public ResponseBean getTReservationByUserCardNumber(JSONObject jsonObject) {

        List<JSONObject> getTReservationByUserCardNumber = tReservationDao.getTReservationByUserCardNumber(jsonObject);

        System.out.println(getTReservationByUserCardNumber);
        return new ResponseBean(100,"This operation is successful",getTReservationByUserCardNumber);
    }

    /**
     * 预约提交上送
     */
    @Override
    public ResponseBean insertByReservation(JSONObject jsonObject) {

        //效验已经预约的活动不能重新预约
        List<JSONObject> getReservationIds = tReservationDao.getReservationId(jsonObject);
        if (getReservationIds.size()==0 ){
                //UUID生成put进jsonObject作为id参数
                jsonObject.put("id", UUID.randomUUID().toString().replace("-", ""));
                int res = tReservationDao.insertByReservation(jsonObject);
                return new ResponseBean(100, "This operation is successful", res);
            }
        if (getReservationIds.size()!=0 ){
            for (JSONObject getReservationId : getReservationIds) {
                if (jsonObject.getString("service_unid").equals(getReservationId.getString("service_unid"))){
                return new ResponseBean(400,"您已预约过该活动,请勿重新预约");
            }}
            }

        return new ResponseBean(404, "未知错误");
    }

    @Override
    public ResponseBean deleteReservationById(JSONObject jsonObject) {
        int res = tReservationDao.deleteReservationById(jsonObject);
        if (res == 1){
            return  new ResponseBean(200,"This operation is successful",res);
        }else
            return new ResponseBean(400,"删除失败");
    }
}
