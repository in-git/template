package com.init.index.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Perms implements Serializable {

  private long id;
  private String name;
  private String perms;

}
