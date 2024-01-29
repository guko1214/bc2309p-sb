package com.vtxlab.bootcamp.bootcampbeanconfig.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampbeanconfig.controller.BeanConfigOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



// @Component, means the abstract representative of @Controller, @Service, @Repository
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/v1")
public class BeanConfigController implements BeanConfigOperation {
  
  @Autowired
  private CharSequence superman;

  @Autowired
  private CharSequence superwoman;  

  @Override
  public CharSequence getSuperman() {
    return this.superman;
  }

  @Override
  public CharSequence getSuperwoman() {
    return this.superwoman;
  }

}
