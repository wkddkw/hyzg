package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.Id;

@Data
public class TbAddress {

  @Id
  private Integer id;
  private String address;
  private Integer isParent;
  private Integer parentId;

}
