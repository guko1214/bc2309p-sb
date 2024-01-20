package com.vtxlab.bootcamp.bootcamphelloworld.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
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
