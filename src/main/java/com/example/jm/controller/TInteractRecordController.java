package com.example.jm.controller;



import com.alibaba.fastjson.JSONObject;
import com.example.jm.Model.TInteractRecord;
import com.example.jm.server.TInteractRecordService;
import com.example.jm.utils.result.CommonUtil;
import com.example.jm.utils.result.ResponseBean;
import com.example.jm.utils.tools.RSAEncrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-28 14:22
 */
@Api(tags = "TInteractRecordController",description = "随手拍接口")
@RestController
public class TInteractRecordController {

    protected static final Logger logger = LoggerFactory.getLogger(TInteractRecordController.class);

    //注入Server
    @Autowired
    private TInteractRecordService tInteractRecordService;


    /**
     * 添加：事项记录表
     */
    @ApiOperation("提交随手拍方法")
    @PostMapping("/insertByTIR")
    public ResponseBean insertByTIR(@RequestBody TInteractRecord tInteractRecord) {
        if (tInteractRecord.getCreateDttm() == null) {
            tInteractRecord.setCreateDttm(new Date());
        } else {
            tInteractRecord.setCreateDttm(tInteractRecord.getCreateDttm());
        }
        if (tInteractRecord.getIsDelete() == null || "" == tInteractRecord.getIsDelete()) {
            tInteractRecord.setIsDelete("0");
        }

        int res = tInteractRecordService.insertByTIR(tInteractRecord);
        if (res == 1) {
            return new ResponseBean(100, "This operation is successful", res);
        } else

            return new ResponseBean(400, "This operation failed", -1);

    }



    /**
     * 修改：事项记录表
     */
    @ApiOperation("修改随手拍方法")
    @PostMapping("/7a20e26d44a85d13a9d0deacbbece436")
    public ResponseBean updateByTIR(@RequestBody TInteractRecord tInteractRecord) {
        if (tInteractRecord.getIsDelete() == null || "" == tInteractRecord.getIsDelete()) {
            tInteractRecord.setIsDelete("0");
        }
        int res = tInteractRecordService.updateByTIR(tInteractRecord);

        if (res == 1) {
            return new ResponseBean(100, "This operation is successful", res);
        } else

            return new ResponseBean(400, "This operation failed", -1);
    }


    /**
     *  我的提交的事项详情查询
     */
    @ApiOperation("我的提交的事项详情")
    @PostMapping("/1e77894622a05e7a8b8def35d16a3519")
    public ResponseBean getTIRByUserCreateNum(@RequestBody TInteractRecord jsonObject, HttpServletRequest request) throws Exception {

        logger.info("获得headers头的Authorization字段值");
        String Authorization = request.getHeader("Authorization");
        //解密
        String JMAuthorization = RSAEncrypt.decrypt(Authorization, RSAEncrypt.privateKey);
        if (RSAEncrypt.AgreedKey.equals(JMAuthorization)) {
            logger.info("居民信息效验controller");
            return tInteractRecordService.getTIRByUserCreateNum(jsonObject);
        } else
            return new ResponseBean(400, "Authorization不匹配,请检查",-1);
    }
}
