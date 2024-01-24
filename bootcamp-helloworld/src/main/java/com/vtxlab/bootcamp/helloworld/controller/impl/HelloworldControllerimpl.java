package com.vtxlab.bootcamp.helloworld.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.helloworld.controller.HelloworldController;
import com.vtxlab.bootcamp.helloworld.model.Cat;
import com.vtxlab.bootcamp.helloworld.model.Cinema;
import com.vtxlab.bootcamp.helloworld.model.Film;
import com.vtxlab.bootcamp.helloworld.model.Food;
import com.vtxlab.bootcamp.helloworld.model.ShoppingMall;

// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldControllerimpl implements HelloworldController {


  @Override
  public String helloworld() {
    return "hello world. This is my first app.";
  }

  @Override
  public String sleepString() {
    return "I'm sleeping";
  }  

  @Override
  public int testint() {
    return 8765;
  }

  @Override
  public Integer testInteger() {
    return Integer.valueOf(8768765);
  }

  @Override
  public double testdouble() {
    return 2.498d;
  }

  @Override
  public char testchar() {
    return 'd';
  }

  @Override
  public Character testcharacter() {
    return Character.valueOf('d');
  }  

  @Override
  public  Cat cat() {
    List<String> chklist = new ArrayList<>();
    chklist.add("Food");
    chklist.add("Water");
    Food food = new Food("Chicken");
    //Food food = new Food();
    //Cat cat = new Cat("catcat",chklist);
    Cat cat = new Cat("catcat",chklist, food);
    //Cat cat = new Cat();
    return cat;
  } 

  @Override
  public  String catToString() {
    List<String> chklist = new ArrayList<>();
    chklist.add("Food");
    chklist.add("Water");
    Food food = new Food("Chicken");
    //Food food = new Food();
    //Cat cat = new Cat("catcat",chklist);
    Cat cat = new Cat("catcat",chklist, food);
    //Cat cat = new Cat();
    return cat.toString();
  } 

  @Override
  public ShoppingMall mall() {

    Film filma = new Film("film A",LocalDate.of(2022,1,1));
    Film filmb = new Film("film B",LocalDate.of(2022,1,2));
    Film[] films = new Film[] {filma, filmb};

    Cinema cinemaa = new Cinema("Cinema A",LocalDate.of(2022,1,1),films);

    String[] shopCategory = new String[] {"Sport","Food","Clothing"};

    ShoppingMall mall = new ShoppingMall("K11", 19000,cinemaa,shopCategory);
    return mall;
  }

  @Override
  public String mallString() {

    Film filma = new Film("film A",LocalDate.of(2022,1,1));
    Film filmb = new Film("film B",LocalDate.of(2022,1,2));
    Film[] films = new Film[] {filma, filmb};

    Cinema cinemaa = new Cinema("Cinema A",LocalDate.of(2022,1,1),films);

    String[] shopCategory = new String[] {"Sport","Food","Clothing"};

    ShoppingMall mall = new ShoppingMall("K11", 19000,cinemaa,shopCategory);
    return mall.toString();
  }

}