package com.vtxlab.bootcamp.bcproductdata.dto.receive;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.dto.request.StockQuoteDTO;
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
public class ApiResponseStockQuoteDTO {
  String  code;
  String message;
  List<StockQuoteDTO> data;

}