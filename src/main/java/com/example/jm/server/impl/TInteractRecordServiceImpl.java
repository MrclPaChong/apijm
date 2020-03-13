package com.example.jm.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.Model.TInteractRecord;
import com.example.jm.mapper.TInteractRecordDao;
import com.example.jm.server.TInteractRecordService;

import com.example.jm.utils.result.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cl
 * @company XX公司
 * @create 2019-09-11 16:06
 */
@Service
public class TInteractRecordServiceImpl implements TInteractRecordService {

    //注入Dao
    @Autowired
    private TInteractRecordDao tInteractRecordDao;


    @Override
    public ResponseBean getTIRByUserCreateNum(TInteractRecord tInteractRecord) {
        List<JSONObject> list = tInteractRecordDao.getTIRByUserCreateNum(tInteractRecord);

        System.out.println(list);
        return new ResponseBean(100,"This operation is successful",list);
    }

    @Override
    public int updateByTIR(TInteractRecord tInteractRecord) {
        return tInteractRecordDao.updateByTIR(tInteractRecord);
    }

    @Override
    public int insertByTIR(TInteractRecord tInteractRecord) {
        return tInteractRecordDao.insertByTIR(tInteractRecord);
    }
}
