package com.vtxlab.bootcamp.bootcampsbforum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Component
public class AppStartRunner implements CommandLineRunner {
  
  @Autowired
  ForumDatabaseService forumDatabaseService;

  @Autowired
  UserService userService;

  @Override
  public void run(String ... args) {
    System.out.println("hello world - App Start Process.");

    //throw new RuntimeException("Server is not ready");
    forumDatabaseService.deleteAllUsers();

    List<User> users = userService.getUsers();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> userEntities = users.stream()
      .map(e -> {
        return com.vtxlab.bootcamp.bootcampsbforum.entity.User.builder() //
          .jphId(e.getId()) //
          .name(e.getName()) //
          .username(e.getUsername()) //
          .email(e.getEmail()) //
          .phone(e.getPhone()) //
          .website(e.getWebsite()) //
          .addrLat(e.getAddress().getGeo().getLat())
          .addrLng(e.getAddress().getGeo().getLng())
          .street(e.getAddress().getStreet())
          .suite(e.getAddress().getSuite())
          .city(e.getAddress().getCity())
          .zipcode(e.getAddress().getZipcode())
          .cName(e.getCompany().getName())
          .catchPhrase(e.getCompany().getCatchPhrase())
          .cBusinessService(e.getCompany().getBs())
          .build();
      })
      .collect(Collectors.toList());      

      //System.out.println("UserEntity =" + userEntities);

      // Save to DB
      forumDatabaseService.saveAllUsers(userEntities);
    
  }

}
