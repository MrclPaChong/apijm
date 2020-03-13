package com.example.jm.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.Model.TInteractRecord;

import java.util.List;

/**
 * @author cl
 * @company XX公司
 * @create 2019-09-11 15:44
 */
public interface TInteractRecordDao {


    /**
     * 查询已提交的事项
     */
    List<JSONObject> getTIRByUserCreateNum(TInteractRecord tInteractRecord);

    /**
     *  添加
     */
    int insertByTIR(TInteractRecord tInteractRecord);

    /**
     *  修改
     */
    int updateByTIR(TInteractRecord tInteractRecord);
}
