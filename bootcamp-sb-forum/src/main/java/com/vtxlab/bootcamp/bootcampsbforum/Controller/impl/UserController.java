package com.vtxlab.bootcamp.bootcampsbforum.Controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.Controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class UserController implements UserOperation {
  
  @Autowired
  private UserService userservice;

  @Override
  public List<User> getUsers() {
    return userservice.getUsers();
  }

  @Override
  public User getUser(int idx) {
    return userservice.getUser(idx);
  }

  @Override
  public String getUserName(int idx) {
    return userservice.getUserName(idx);
  }

}
