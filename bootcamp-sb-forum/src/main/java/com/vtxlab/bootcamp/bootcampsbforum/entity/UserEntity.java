package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // Class mapped to the db table
@Table(name = "USERS2")
@Getter
@Setter
//@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {
  
  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //private int jphId;
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

  @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<PostEntity> posts = new ArrayList<>();

}
