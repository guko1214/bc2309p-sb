package com.vtxlab.bootcamp.bootcampsbforum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "POSTS2")
@Setter
@Getter
//@ToString
@AllArgsConstructor
@Builder
public class PostEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Column(length = 1000)
  private String body;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "ID") // FK
  @JsonBackReference
  private UserEntity user2; 

}
