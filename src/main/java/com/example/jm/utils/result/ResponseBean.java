package com.example.jm.utils.result;

import com.alibaba.fastjson.JSONObject;
import java.util.List;


/**
 * ResponseBean
 * @author dolyw.com
 * @date 2018/8/30 11:39
 */
public class ResponseBean {
    /**
     * HTTP状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object data;


    /**
     * 返回数据
     */
    public ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回数据
     */
    public ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 返回JsonObject数据
     */
    public static JSONObject successJson(int code, String msg,JSONObject info) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", code);
        resultJson.put("msg", msg);
        resultJson.put("info", info);
        return resultJson;
    }
    /**
     * 返回List JsonObject数据
     */
    public static JSONObject successJsonList(int code, String msg,List<JSONObject> info) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", code);
        resultJson.put("msg", msg);
        resultJson.put("info", info);
        return resultJson;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
