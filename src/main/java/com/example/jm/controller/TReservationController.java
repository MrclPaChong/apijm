package com.example.jm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.server.TReservationServer;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ResponseBean;
import com.example.jm.utils.tools.RSAEncrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.IllegalBlockSizeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:58
 */
@RestController
public class TReservationController {

    protected static final Logger logger = LoggerFactory.getLogger(TReservationController.class);
    //注入server
    @Autowired
    private TReservationServer tReservationServer;


    /**
     *  返回公匙给对方
     */
    @GetMapping("dcc242d7489c582da798677d64b81fcd")
    public ResponseBean PublicKey(HttpServletResponse httpServletResponse) throws Exception{

        //公匙
        String  PublicKey = RSAEncrypt.publicKey;
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "The public key was generated successfully");
        httpServletResponse.setHeader("PublicKey", PublicKey);

        return new ResponseBean(200,"PublicKey获取成功(headers头里：PublicKey)",1);
    }


    /**
     * 测试查询接口
     * @return
     */
    @PostMapping("/getByAll")
    public JSONObject getByAll(){
         return tReservationServer.getByAll();
    }

    /**
     * 预约提交上送
     * @return
     */
    @PostMapping("/dab30c4061c453aab6bc2573353becf2")
    public ResponseBean insertByReservation(@RequestBody JSONObject requestJson, HttpServletRequest request) throws Exception{

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("进入预约提交上送controller");
            //效验请求参数
            CommonUtil.hasAllRequired(requestJson, "service_unid,appointment_date,timezone,mobile,idcard,realname");
            return tReservationServer.insertByReservation(requestJson);
        }else
         return new ResponseBean(400,"请求处理异常，请稍后再试");
    }
}
