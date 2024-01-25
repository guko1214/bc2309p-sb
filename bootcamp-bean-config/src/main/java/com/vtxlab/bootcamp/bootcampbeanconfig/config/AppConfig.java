package com.vtxlab.bootcamp.bootcampbeanconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // one of the @Component
public class AppConfig {
  
  @Bean
  String superman() {
    return "Superman!!!";
  }

  @Bean
  String superwoman() {
    return "Superwoman!!!";
  }
}
