package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductCoinsEntity;

public interface TproductCoinsEntityRepository extends JpaRepository<TproductCoinsEntity, Long> {
  
}
