package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // one of the @Component
public class Appconfig {
  
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
