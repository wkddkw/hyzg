package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "tb_user")
public class TbUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String password;

  private Integer tel;

  private Integer idCard;

  private String linkMan;

  private String email;

  private String weixin;

  private String qq;

  private String idImage;

  private String ctfImage;

  private Integer roleId;

  private String province;

  private String city;

  private String area;

  private java.sql.Timestamp createTime;

  private java.sql.Timestamp lastUpdateTime;

  private Integer isVip;

}
