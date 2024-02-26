package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.controller.RedisOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/redis/api/v1")
public class RedisController implements RedisOperation {
  
@Autowired
RedisService redisService;

  public User2 createUser2(String key, User2 user) throws JsonProcessingException {
    return redisService.createUser2(key, user);
  };

  public User2 getUser2(@RequestParam String key) throws JsonProcessingException{
    return redisService.getUser2(key);
  };

}
