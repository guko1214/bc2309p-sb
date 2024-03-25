package com.vtxlab.bootcamp.bcproductdata.repostitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStockListEntity;

public interface StocksIdEntityRepository extends JpaRepository<TproductStockListEntity,Long> {
  
  List<TproductStockListEntity> findByStockCode(String stockCode);

}
