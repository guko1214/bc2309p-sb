package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {
  
  List<User> getUsers();

  User getUser(int idx);

  String getUserName(int idx);

  UserEntity save(UserPostRequestDTO dto);
}
