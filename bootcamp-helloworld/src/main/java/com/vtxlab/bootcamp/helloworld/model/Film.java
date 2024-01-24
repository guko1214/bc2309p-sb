package com.vtxlab.bootcamp.helloworld.model;

import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Film {
  public String name;
  public LocalDate releaseDate;

  public Film(String name, LocalDate releaseDate) {
    this.name = name;
    this.releaseDate = releaseDate;
  }
}