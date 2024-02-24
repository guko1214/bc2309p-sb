package com.vtxlab.bootcamp.bccryptocoingecko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class coins {
  
  private String id;
  private String symbol;
  private String name;

}
