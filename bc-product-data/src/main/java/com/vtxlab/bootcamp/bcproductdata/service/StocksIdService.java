package com.vtxlab.bootcamp.bcproductdata.service;

import java.util.List;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface StocksIdService {
    List<StocksIdEntity> saveStocksIds(List<StocksIdEntity> stocksIds);
}
