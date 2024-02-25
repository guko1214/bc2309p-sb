package com.vtxlab.bootcamp.bccryptocoingecko.annotation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.vtxlab.bootcamp.bccryptocoingecko.model.VsCurrency;
import com.vtxlab.bootcamp.bccryptocoingecko.service.CoingeckoService;
import com.vtxlab.bootcamp.bccryptocoingecko.service.impl.CoingeckoServiceHolder;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VsCurrencyValidator implements ConstraintValidator<VsCurrencyCheck, VsCurrency> {
  
  // @Autowired
  // List<VsCurrency> supportedVsCurrencies;
  @Autowired
  CoingeckoService coingeckoService;

  @Override
  public boolean isValid(VsCurrency cur, ConstraintValidatorContext context) {
    try {
     // CoingeckoService coingeckoService2 = new CoingeckoServiceHolder();
      // return coingeckoService.getSupporedVsCurrencies().contains(cur);
      return false;
      //return supportedVsCurrencies.contains(cur);
    } catch (Exception e) {
      return false;
    }
  }

}
