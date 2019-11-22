package com.syc.china.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_car_resource")
public class CarResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startProvince;
    private String startCity;
    private String startArea;
    private String endProvince;
    private String endCity;
    private String endArea;
    @JsonIgnore
    private Integer carTypeId;
    @Transient
    private String carType;

    private Double carLength;
    private Double carWeight;

    @JsonIgnore
    private Integer unitId;
    @Transient
    private String unit;

    @JsonIgnore
    private Integer proDetailTypeId;
    @Transient
    private String proType;

    @JsonIgnore
    private Integer transTypeId;
    @Transient
    private String transType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String backTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String availableTime;
    private String detail;
    private String linkMan;
    private String tel;
    private String email;
    private String qq;
    private Date createTime;
    private Date lastUpdateTime;
}