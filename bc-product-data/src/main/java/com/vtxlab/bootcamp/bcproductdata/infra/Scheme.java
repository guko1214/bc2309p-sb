package com.vtxlab.bootcamp.bcproductdata.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String toLowercase() {

    return this.toString().toLowerCase();
  }
}

