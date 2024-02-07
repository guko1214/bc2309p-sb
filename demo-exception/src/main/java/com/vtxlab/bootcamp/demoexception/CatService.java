package com.vtxlab.bootcamp.demoexception;

public class CatService {
  public Cat getCat(int x) {
    if (x > 10)
      throw new IllegalArgumentException();
    return new Cat("John",10);
  }
}