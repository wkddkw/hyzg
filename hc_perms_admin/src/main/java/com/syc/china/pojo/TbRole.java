package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.Id;

@Data
public class TbRole {

  @Id
  private Integer id;

  private String role;

}
