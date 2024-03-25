package com.vtxlab.bootcamp.bcproductdata.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TproductsDTO {

  private String productId;
  private String name;
  private Double currentPrice;
  private Double priceChgPct;
  private Double marketCap;
  private String logo;

}
