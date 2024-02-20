package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;

@Configuration // one of the @Component
public class Appconfig {
  
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
  //   // RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
  //   // redisTemplate.setConnectionFactory(factory);
  //   // redisTemplate.setKeySerializer(RedisSerializer.string());
  //   // redisTemplate.setValueSerializer(RedisSerializer.json());
  //  // return redisTemplate;
  // }

    @Bean
    RedisHelper redisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper) {
      return new RedisHelper(factory, objectMapper);
    }

    @Bean
    ObjectMapper objectMapper() {
      return new ObjectMapper();
    }

}


