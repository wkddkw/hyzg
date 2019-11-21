package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.Id;

@Data
public class TbRolePerms {

  @Id
  private long roleId;

  private long permsId;

}
