package com.example.jm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.server.TRoomuserServer;
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
 * @create 2020-01-03 11:21
 */
@Api(tags = "TRoomuserController",description = "居民档案上送接口")
@RestController
public class TRoomuserController {

    protected static final Logger logger = LoggerFactory.getLogger(TRoomuserController.class);

    //注入
    @Autowired
    private TRoomuserServer tRoomuserServer;

    /**
     * 居民信息效验  网格员信息效验
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation("网格员信息效验")
    @PostMapping("/eaab88196bc447ad8b217b75a1acb3de")
    public ResponseBean getByRoomuserExist(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception{

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("居民信息效验controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject,"CardNumber");
            return tRoomuserServer.getByRoomuserExist(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");
    }

    /**
     *居民信息采集上送
     * @param jsonObject
     * @return
     */
    @ApiOperation("居民信息采集")
    @PostMapping("/ab8baa59880b4e0d8eb40cc471ef434f")
    public ResponseBean insertByTIR(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("居民信息采集controller");
 /*           //效验请求参数
            CommonUtil.hasAllRequired(jsonObject, "RoomerName,CallPhone,CardNumber,RoomNumber,RoomAddress,RoomUserType,\n" +
                    "       CheckInTime,IdentyPhoto,IsHaveVehicle,VehicleNo,CreateUserID,ImgUrl,Remark,BuildingName,AreaName,SourceType,\n" +
                    "       Nation,LiveType,IsForeign,HouseHoldType,HousePlace,Age,TenantStartTime,TenantEndTime,Sex");*/
            return tRoomuserServer.insertByRoomuser(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }

    /**
     * 居民信息修改
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/e103c1c7061f419bb21e387a3d602592")
    public ResponseBean UpdateByRoomuser(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("居民信息采集controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject,"ID");
            return tRoomuserServer.UpdateByRoomuser(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }


    /**
     * 删除居民信息
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/aefd666a115b4d0f8718c2f16a149bbd")
    public ResponseBean DeleteByRoomuser(@RequestBody JSONObject jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization,RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("居民信息采集controller");
            //效验请求参数
            CommonUtil.hasAllRequired(jsonObject,"ID");

            return tRoomuserServer.delByRoomuser(jsonObject);
        }else
            return new ResponseBean(400,"Authorization不匹配,请检查");

    }
}
