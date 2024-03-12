package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.CpCoingeckoMKEntity;

public interface CpCoingeckoMKEntityRespository extends JpaRepository<CpCoingeckoMKEntity,Long> {
  
}
