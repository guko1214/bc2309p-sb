package com.vtxlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bcproductdata.dto.mapper.DtoMapper;
import com.vtxlab.bootcamp.bcproductdata.dto.request.CoinsMKDataDTO;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;
import com.vtxlab.bootcamp.bcproductdata.service.ProductDataService;

@Controller
public class WebPageController {
  
  @Autowired
  ProductDataService productDataService;

  @GetMapping(value = "/coinsdata")
  public String displayExternalData(Model model) {
    List<TexCPCoingeckoMKEntity> texCPCoingeckoMKEntities = productDataService.findAllTexCPCoingeckoMKEntites();
    List<CoinsMKDataDTO> coinsMKDatas = DtoMapper.texCPCoingeckoMKEntityMap(texCPCoingeckoMKEntities.subList(texCPCoingeckoMKEntities.size()-14,texCPCoingeckoMKEntities.size()));
    model.addAttribute("coinsMKDatas", coinsMKDatas);
    return "coin-data";
  }

}
