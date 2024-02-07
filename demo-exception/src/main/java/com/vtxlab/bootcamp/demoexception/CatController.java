package com.vtxlab.bootcamp.demoexception;

public class CatController {
  
  public Cat getCat() {
    try {
    Cat cat = new CatService().getCat(10); // exception
    System.out.println("after call");
    return cat;
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

  public static void main(String[] args) {

    System.out.println(new CatController().getCat());
  }

}
