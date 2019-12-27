package com.example.jm.utils.exception;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ErrorEnum;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-27 8:54
 */
public class CommonJsonException extends RuntimeException {
    private JSONObject resultJson;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     *
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJson = CommonUtil.errorJson(errorEnum);
    }

    public CommonJsonException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
}
