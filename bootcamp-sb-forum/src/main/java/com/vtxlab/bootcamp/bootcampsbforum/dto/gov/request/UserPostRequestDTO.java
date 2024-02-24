package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request;

import java.util.List;
import lombok.Getter;

@Getter
public class UserPostRequestDTO {
  
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String addrLat;
  private String addrLong;
  private String companyName;
  private String companyCatchPhrase;
  private String companyBusService;
  private List<PostRequestDto> posts;

  @Getter
  public static class PostRequestDto {
    private String title;
    private String body;
  }

  
}
