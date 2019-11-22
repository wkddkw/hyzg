package com.syc.china.pojo;

import lombok.Data;

@Data
public class CarKey {

    private String startProvince;
    private String startCity;
    private String startArea;
    private String endProvince;
    private String endCity;
    private String endArea;
    private Integer transTypeId;
    private Integer carTypeId;

}
