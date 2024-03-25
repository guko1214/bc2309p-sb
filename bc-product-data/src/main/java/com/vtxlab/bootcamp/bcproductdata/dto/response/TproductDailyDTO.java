package com.vtxlab.bootcamp.bcproductdata.dto.response;

import java.time.LocalDate;
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
public class TproductDailyDTO {

  private String productId;
  private String tradeDate;
  private Double dayHigh;
  private Double dayLow;
  private Double dayOpen;
  private Double dayClose;
}
