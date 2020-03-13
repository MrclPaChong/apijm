package com.example.jm.server;


import com.example.jm.Model.TInteractRecord;
import com.example.jm.utils.result.ResponseBean;

/**
 * @author cl
 * @company XX公司
 * @create 2019-09-11 16:06
 */
public interface TInteractRecordService {




    /**
     * 查询已提交的事项
     */
    ResponseBean getTIRByUserCreateNum(TInteractRecord tInteractRecord);


    /**
     *  添加
     */
    int insertByTIR(TInteractRecord tInteractRecord);

    /**
     *  修改
     */
    int updateByTIR(TInteractRecord tInteractRecord);
}
