package com.syc.china.pojo;


import lombok.Data;
import org.apache.shiro.authz.permission.InvalidPermissionStringException;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Table(name = "tb_user")
public class TbUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String password;

  private String phone;

  private String idCard;

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

  private Date createTime;

  private Date lastUpdateTime;

  private Boolean isVip;

  @Transient
  private List<TbRole> roles;

  @Transient
  private List<TbPerm> perms;

}
