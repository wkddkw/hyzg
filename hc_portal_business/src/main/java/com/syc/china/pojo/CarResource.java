package com.syc.china.pojo;

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
    private Double carLength;
    private Double carWeight;

    @JsonIgnore
    private Integer unitId;
    @JsonIgnore
    private Integer proDetailTypeId;
    @JsonIgnore
    private Integer transTypeId;

    private Date backTime;
    private Date availableTime;
    private String detail;
    private String linkMan;
    private String tel;
    private String email;
    private String qq;
    private Date createTime;
    private Date lastUpdateTime;

    @Transient
    private String carType;
    @Transient
    private String unit;
    @Transient
    private String proDetailType;
    @Transient
    private String transType;
}