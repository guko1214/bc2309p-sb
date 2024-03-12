package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.StocksIdEntity;

public interface StocksIdEntityRespository extends JpaRepository<StocksIdEntity,Long> {
  
}
