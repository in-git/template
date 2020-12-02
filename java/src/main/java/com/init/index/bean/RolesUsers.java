package com.init.index.bean;

import lombok.Data;

import java.io.Serializable;

@Data

public class RolesUsers implements Serializable {

  private long id;
  private long usersId;
  private long rolesId;



}
