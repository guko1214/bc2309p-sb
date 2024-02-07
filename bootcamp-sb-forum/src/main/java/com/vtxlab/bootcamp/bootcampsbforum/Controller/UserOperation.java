package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<User> getUsers();

  @GetMapping(value = "/user/{idx}")
  User getUser(@PathVariable int idx);

  @GetMapping(value = "/user/{idx}/name")
  String getUserName(@PathVariable int idx);

}
