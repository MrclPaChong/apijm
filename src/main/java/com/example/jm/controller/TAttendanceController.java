package com.example.jm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.server.TAttendanceServer;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ResponseBean;
import com.example.jm.utils.tools.RSAEncrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cl
 * @company XX公司
 * @create 2020-01-14 17:23
 */
@Api(tags = "TRoomuserController",description = "考勤接口")
@RestController
public class TAttendanceController {

    protected static final Logger logger = LoggerFactory.getLogger(TAttendanceController.class);

    //注入server
    @Autowired
    private TAttendanceServer tAttendanceServer;


    /**
     *考勤记录上送
     * @param jsonObject
     * @return
     */
    @ApiOperation("考勤记录上送")
    @PostMapping("/b8d4ad3683f45d75a14ac04b032c354b")
    public ResponseBean insertByTA(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("考勤记录controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject, "content,palmHandUrl1,positionGps,createId,createNum,resiName");
            return tAttendanceServer.insertByTA(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }


    /**
     *考勤记录查询
     * @param jsonObject
     * @return
     */
    @ApiOperation("考勤记录查询")
    @PostMapping("/d0eca528cf4056e19a33757b5e66fe0f")
    public ResponseBean insertByTIR(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("考勤记录controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject, "flag,createNum");
            return tAttendanceServer.selectByTA(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }

    /**
     *考勤记录查询:根据年、月、天查询月数据
     * @param jsonObject
     * @return
     */
    @ApiOperation("考勤记录查询:根据年、月、天查询月数据")
    @PostMapping("/e0de8692031d59d49f2355fce7d28ebf")
    public ResponseBean selectMonthByYearByMonthByDay(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("考勤记录controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject, "createNum,year");
            return tAttendanceServer.selectMonthByYearByMonthByDay(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }

}
