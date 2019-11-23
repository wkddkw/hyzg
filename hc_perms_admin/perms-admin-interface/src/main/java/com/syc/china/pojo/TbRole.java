package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
public class TbRole {

  @Id
  private Integer id;

  private String role;

  @Transient
  private List<TbPerm> perms;

}
