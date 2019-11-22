package com.syc.china.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_pro_resource")
public class ProResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private Integer proTypeId;
    private String proName;

    @JsonIgnore
    private Integer proDetailTypeId;
    private Integer num;

    @JsonIgnore
    private Integer unitId;
    @JsonIgnore
    private Integer transTypeId;

    private String startProvince;
    private String startCity;
    private String startArea;
    private String endProvince;
    private String endCity;
    private String endArea;
    private Long price;

    @JsonIgnore
    private Integer priceUnitId;
    private String name;
    private String tel;
    private String email;
    private String qq;
    private Date createTime;
    private Date lastUpdateTime;

    @Transient
    private String proType;
    @Transient
    private String proDetailType;
    @Transient
    private String unit;
    @Transient
    private String transType;
    @Transient
    private String priceUnit;
}
