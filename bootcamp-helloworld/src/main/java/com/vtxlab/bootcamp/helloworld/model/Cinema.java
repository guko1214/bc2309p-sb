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
public class Cinema {
  public String name;
  public LocalDate openedDate;
  public Film[] releasedFilms;

  public Cinema(String name, LocalDate openedDate, Film[] releasedFilms) {
    this.name = name;
    this.openedDate = openedDate;
    this.releasedFilms = releasedFilms;
  }
}
