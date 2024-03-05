package com.vtxlab.bootcamp.bootcampdemothymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping(value = "/api/v1")
public class HelloworldController { // bean
  
  //@Autowired

  @GetMapping(value = "/greeting")
  public String hello(Model model) { // pass by reference

    // call service layer

    model.addAttribute("tutor", "Vincent Lau");
    model.addAttribute("student", "Derrick Shum");

    return "helloworld"; // helloworld.html
  }

}
