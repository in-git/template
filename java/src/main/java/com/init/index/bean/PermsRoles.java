package com.init.index.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PermsRoles implements Serializable {

  private long id;
  private long permsId;
  private long rolesId;

}
