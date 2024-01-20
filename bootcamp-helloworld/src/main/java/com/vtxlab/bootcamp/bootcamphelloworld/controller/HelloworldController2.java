package com.vtxlab.bootcamp.bootcamphelloworld.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcamphelloworld.model.Cat;
import com.vtxlab.bootcamp.bootcamphelloworld.model.Food;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v2")
public class HelloworldController2 {



  //@GetMapping(value = "/api/v1/helloworld") // path
  @GetMapping(value = "/helloworld") // path
  public String helloworld() {
    return "hello world. Version 2.";
  }

  // @GetMapping(value = "/api/v1/sleep") // path
  @GetMapping(value = "/sleep") // path // path end should be noun
  public String sleepString() {
    return "I'm sleeping";
  }  

  @GetMapping(value = "/testint") // path 
  public int testint() {
    return 8765;
  }

  @GetMapping(value = "/testinteger") // path 
  public Integer testInteger() {
    return 8768765;
  }

  @GetMapping(value = "/testdouble") // path 
  public double testdouble() {
    return 2.498d;
  }

  @GetMapping(value = "/testchar") // path 
  public char testchar() {
    return 'd';
  }

  @GetMapping(value = "/testCharacter") // path 
  public Character testcharacter() {
    return 'd';
  }  

  @GetMapping(value = "/cat") // path 
  public  Cat testHelloworldController() {
    List<String> chklist = new ArrayList<>();
    chklist.add("Food");
    chklist.add("Water");
    //Food food = new Food("Chicken");
    Food food = new Food();
    //Cat cat = new Cat("catcat",chklist);
    //Cat cat = new Cat("catcat",chklist, food);
    Cat cat = new Cat();
    return cat;
  } 


}