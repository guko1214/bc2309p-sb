package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TproductStocksEntityRepository extends JpaRepository<TproductStockListEntity,Long> {
  
}
