package com.vtxlab.bootcamp.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.helloworld.model.Cat;
import com.vtxlab.bootcamp.helloworld.model.ShoppingMall;

public interface HelloworldController {

  @GetMapping(value = "/helloworld") // path
  String helloworld();

  @GetMapping(value = "/sleep") // path // path end should be noun
  String sleepString();

  @GetMapping(value = "/testint") // path 
  int testint();

  @GetMapping(value = "/testinteger") // path 
  Integer testInteger();

  @GetMapping(value = "/testdouble") // path 
  double testdouble();

  @GetMapping(value = "/testchar") // path 
  char testchar();

  @GetMapping(value = "/testCharacter") // path 
  Character testcharacter();

  @GetMapping(value = "/cat") // path 
  Cat cat();

  @GetMapping(value = "/catString") // path 
  String catToString();

  @GetMapping(value = "/shoppingmall")
  ShoppingMall mall();

  @GetMapping(value = "/shoppingmallString")
  String mallString();

}