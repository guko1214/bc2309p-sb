package com.vtxlab.bootcamp.bootcampsbforum.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String toLowercase() {

    return this.toString().toLowerCase();
  }
}
