package com.example.jm.Model;

import lombok.Data;

import java.util.Date;

/**
 * @author cl
 * @company XX公司
 * @create 2019-09-11 15:21
 * 事项记录表
 */
@Data
public class TInteractRecord {

    /**
     *  事项记录表(主键)
     */
    private String id;

    /**
     *  类型代码
     */
    private String dictCode;

    /**
     *  描述
     */
    private String describe;

    /**
     *  照片URL1
     */
    private String palmHandUrl1;

    /**
     *  照片URL1
     */
    private String palmHandUrl2;

    /**
     *  照片URL1
     */
    private String palmHandUrl3;

    /**
     *  精度
     */
    private String lon;

    /**
     *  纬度
     */
    private String lat;

    /**
     *  gps
     */
    private String positionGps;

    /**
     *  用户ID
     */
    private String createId;

    /**
     *  证件编号
     */
    private String createNum;

    /**
     *  姓名
     */
    private String resiName;

    /**
     *  联系电话
     */
    private String resiTel;

    /**
     *  创建时间
     */
    private Date  createDttm;

    /**
     *  小区id
     */
    private String areaId;

    /**
     *  小区名程
     */
    private String areaName;

    /**
     *  状态：1、待处理；2、处理中；3、已处理；4、已撤销；5、其它
     */
    private String  status;

    /**
     *  是否删除：0是未删除，1是已删除
     */
    private String isDelete;

    /**
     *  小区名程    HANDLE_NAME
     */
    private String handleName;

    /**
     *  处理单位
     */
    private String handleEntity;

    /**
     *  处理时间
     */
    private Date handleDttm;

    /**
     *  处理描述
     */
    private String handleDesc;

    /**
     *  备注
     */
    private String remark;


}
