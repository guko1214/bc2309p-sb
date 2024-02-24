package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse2;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

  public User getUser(int idx) {
    return userservice.getUser(idx);
  };

  @Override
  public String getUserName(int idx) {
    return userservice.getUserName(idx);
  }

  @Override
  public ApiResponse2<UserEntity> saveUserAndPosts(UserPostRequestDTO dto) {
    UserEntity userEntity = userservice.save(dto);
    return ApiResponse2.<UserEntity>builder()
    .status(Syscode.OK)
    .data(userEntity)
    .build();
  };

}
