package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJPHServiceHolder implements UserService {

  @Value("${api.jsonPlaceHolder.domain}")
  private String domain;

  @Value("${api.jsonPlaceHolder.endpoints.users}")
  private String userUri;

  @Override
  public List<User> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
    // call API
    // 1. invoke jsonplaceholder.typicode.com/users
    // 2. deserialization (From JSON String to Java Object)
    //String url = "https://jsonplaceholder.typicode.com/users";
    //restTemplate.getForObject(url, User.class);
    //User[] users = restTemplate.getForObject(url, User[].class);
    String url = BcUtil.getUrl(Scheme.HTTPS,domain, userUri);
    User[] users = restTemplate.getForObject(url, User[].class);
    // array -> list
    return Arrays.stream(users).collect(Collectors.toList());
  };

  @Override
  public User getUser(int idx) {
    RestTemplate restTemplate = new RestTemplate();
    User[] users = restTemplate.getForObject(
        BcUtil.getUrl(Scheme.HTTPS,domain, userUri), User[].class);
    try {
      return users[idx];
    } catch (NullPointerException e) {
      return new User();
    }
  }

  @Override
  public String getUserName(int idx) {
    RestTemplate restTemplate = new RestTemplate();
    String url = BcUtil.getUrl(Scheme.HTTPS,domain, userUri);
    User[] users = restTemplate.getForObject(url, User[].class);
    //User user = users[idx];
    try {
      return users[idx].getName();
    } catch (NullPointerException e) {
      return "";
    }
  }



}
