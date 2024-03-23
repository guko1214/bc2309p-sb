package com.vtxlab.bootcamp.bcproductdata.dto.receive;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockProfile2DTO;
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
public class ApiResponseCoinMKDataDTO {
  String  code;
  String message;
  List<CoinsMKDataDTO> data;
}
