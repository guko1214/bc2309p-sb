package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@Service
public class RedisServiceimpl implements RedisService {
  
  @Autowired
  //private RedisTemplate<String, String> redisTemplate;
  private RedisHelper redisHelper;

  @Override
  public User2 createUser2(String key, User2 user) throws JsonProcessingException {
    // user -> json (String)
    // ObjectMapper objectMapper = new ObjectMapper();
    // String serialized = objectMapper.writeValueAsString(user);
    // redisTemplate.opsForValue().set(key, serialized);
    redisHelper.set(key, user);
    return user;
  }

}
