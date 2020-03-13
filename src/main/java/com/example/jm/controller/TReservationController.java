package com.example.jm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.server.TReservationServer;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ResponseBean;
import com.example.jm.utils.tools.RSAEncrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 14:58
 */
@Api(tags = "TReservationController",description = "预约接口")
@RestController
public class TReservationController {

    protected static final Logger logger = LoggerFactory.getLogger(TReservationController.class);
    //注入server
    @Autowired
    private TReservationServer tReservationServer;


    /**
     *  返回公匙给对方
     */
    @ApiOperation("获取公匙方法")
    @PostMapping("dcc242d7489c582da798677d64b81fcd")
    public ResponseBean PublicKey(HttpServletResponse httpServletResponse) throws Exception{

        //公匙
        String  PublicKey = RSAEncrypt.publicKey;
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "The public key was generated successfully");
        httpServletResponse.setHeader("PublicKey", PublicKey);

        return new ResponseBean(200,"PublicKey获取成功(headers头里：PublicKey)",1);
    }


    /**
     * 用户查询预约活动
     */
    @ApiOperation("用户查询预约活动方法")
    @PostMapping("/2f301433a4c6493796b0ea8ee24af305")
    public ResponseBean getTReservationByUserCardNumber(@RequestBody JSONObject requestJson, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization, RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("进入用户查询预约controller");
            //效验请求参数
            CommonUtil.hasAllRequired(requestJson, "idcard");
            return tReservationServer.getTReservationByUserCardNumber(requestJson);
        } else
            return new ResponseBean(400, "Authorization不匹配,请检查",-1);
    }

    /**
     * 预约提交上送
     * @return
     */
    @ApiOperation("预约提交方法")
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
            return new ResponseBean(400,"Authorization不匹配,请检查");
    }

    /**
     *  删除已预约的活动
     */
    @ApiOperation("删除已预约的活动")
    @PostMapping("/fa4ca9634f795f4c8c5a486da979a5a0")
    public ResponseBean deleteReservationById(@RequestBody JSONObject requestJson, HttpServletRequest request) throws Exception{

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("进入预约提交上送controller");
            //效验请求参数
            CommonUtil.hasAllRequired(requestJson, "id");
            return tReservationServer.deleteReservationById(requestJson);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");
    }
}
