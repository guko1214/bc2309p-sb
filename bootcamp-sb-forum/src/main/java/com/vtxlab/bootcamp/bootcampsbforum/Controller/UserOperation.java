package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse1;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<User> getUsers();

  @GetMapping(value = "/user/{idx}")
  User getUser(@PathVariable int idx);

  @GetMapping(value = "/user/{idx}/name")
  String getUserName(@PathVariable int idx);

  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse2<UserEntity> saveUserAndPosts(@RequestBody UserPostRequestDTO dto);

}
