package com.vtxlab.bootcamp.bootcampsbforum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Class mapped to the db table
@Table(name = "USERS")
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int jphId;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADDR_LAT")
  private String addrLat;
  @Column(name = "ADDR_LNG")
  private String addrLng;
  @Column(name = "COMP_NAME")
  private String cName;
  @Column(name = "COMP_CATCH_PHASE")
  private String catchPhrase;
  @Column(name = "COMP_BUSINESS_SERVICE")
  private String cBusinessService;
}
