package com.example.jm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jm.utils.tools.RSAEncrypt;
import com.example.jm.utils.result.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author cl
 * @company XX公司
 * @create 2019-12-26 0:13
 */
@RestController
public class TestController {

    protected static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     *  返回公匙给对方
     */
    @RequestMapping("PublicKey")
    public ResponseBean PublicKey(HttpServletResponse httpServletResponse) throws Exception{

        //公匙
        String  PublicKey = RSAEncrypt.publicKey;
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "The public key was generated successfully");
        httpServletResponse.setHeader("Authorization", PublicKey);

        return new ResponseBean(200,"success",1);
    }


    /**
     * 获得Authorization的约定
     */
    @PostMapping("/Authorization")
    public ResponseBean Authorization(HttpServletRequest request){

         String Authorization = request.getHeader("Authorization");

        return new ResponseBean(200,"success",Authorization);
    }

    @PostMapping("/jiamishuju")
    public ResponseBean jiamishuju(@RequestBody JSONObject jsonObject) throws Exception{

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String timestamp = jsonObject.getString("timestamp");
        logger.info("接收参数1："+username+"\t接收参数2："+password+"\t接收参数3："+timestamp);

        String jusername = RSAEncrypt.decrypt(username,RSAEncrypt.privateKey);
        String jpassword = RSAEncrypt.decrypt(password,RSAEncrypt.privateKey);
        String res = "姓名"+jusername + "密码\n"+jpassword +"时间戳\n"+timestamp;
        logger.info("解密参数1："+jusername+"\t解密参数2："+jpassword);

  /*      String zhengchang = jiemi.substring(0,jiemi.length() - 13);*/
        return new ResponseBean(200,"success",res);
    }


}
