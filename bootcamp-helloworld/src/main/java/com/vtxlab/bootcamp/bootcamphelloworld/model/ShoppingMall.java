package com.vtxlab.bootcamp.bootcamphelloworld.model;

import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ShoppingMall {

  public String name;
  public int area;
  public Cinema cinema;
  public String[] shopCategory;


  public ShoppingMall(String name, int area, Cinema cinema, String[] shopCategory) {
    this.name = name;
    this.area = area;
    this.cinema = cinema;
    this.shopCategory = shopCategory;
  }

  public static void main(String[] args) {
    
  }

  }

    
    


