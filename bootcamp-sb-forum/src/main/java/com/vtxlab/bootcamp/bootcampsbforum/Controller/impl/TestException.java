package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/api/v1")
public class TestException {
  
  @GetMapping("/test/npe")
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }
  

}
