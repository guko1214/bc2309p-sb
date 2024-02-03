package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJPHServiceHolder implements UserService {

  @Override
  public List<User> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
    // call API
    // 1. invoke jsonplaceholder.typicode.com/users
    // 2. deserialization (From JSON String to Java Object)
    String url = "https://jsonplaceholder.typicode.com/users";
    //restTemplate.getForObject(url, User.class);
    User[] users = restTemplate.getForObject(url, User[].class);
    // array -> list
    return Arrays.stream(users).collect(Collectors.toList());
  };

  public User getUser(int idx) {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    User[] users = restTemplate.getForObject(url, User[].class);
    try {
      return users[idx];
    } catch (NullPointerException e) {
      return new User();
    }
  }

  public String getUserName(int idx) {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://jsonplaceholder.typicode.com/users";
    User[] users = restTemplate.getForObject(url, User[].class);
    //User user = users[idx];
    try {
      return users[idx].getName();
    } catch (NullPointerException e) {
      return "";
    }
  }

}
