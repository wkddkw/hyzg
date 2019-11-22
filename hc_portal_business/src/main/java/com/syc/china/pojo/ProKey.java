package com.syc.china.pojo;

import lombok.Data;

@Data
public class ProKey {

    private String startProvince;
    private String startCity;
    private String startArea;
    private String endProvince;
    private String endCity;
    private String endArea;
    private String proName;
    private Integer transTypeId;// 线路类型
    private Integer carTypeId; // 车辆类型
    private Integer proTypeId; // 货物类别
    private Integer proDetailTypeId; // 货物种类详情
    private Integer num;
    private Integer unitId;
}
