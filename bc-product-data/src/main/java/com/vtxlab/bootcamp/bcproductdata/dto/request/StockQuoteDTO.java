package com.vtxlab.bootcamp.bcproductdata.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class StockQuoteDTO {

  private Double c;
  private Double d;
  private Double dp;
  private Double h;
  private Double l;
  private Double o;
  private Double pc;
  private Double t;
}