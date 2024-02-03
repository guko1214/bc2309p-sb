package com.vtxlab.bootcamp.bootcampsbforum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private int id;
  
  private String name;

  private String username;

  private String email;

  private Address address;

  private String phone;

  private String website;

  private Company company; 

  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo;

    @Getter
    public static class Location {
      private String lat;
      private String lng;
    }

  }
  
  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
