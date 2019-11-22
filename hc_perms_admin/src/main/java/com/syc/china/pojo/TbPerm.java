package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.Id;

@Data
public class TbPerm {

  @Id
  private long id;

  private String perm;

  private String comment;

}
