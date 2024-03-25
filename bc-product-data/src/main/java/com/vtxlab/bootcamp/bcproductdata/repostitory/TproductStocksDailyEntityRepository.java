package com.vtxlab.bootcamp.bcproductdata.repostitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksDailyEntity;

public interface TproductStocksDailyEntityRepository extends JpaRepository<TproductStocksDailyEntity,Long>{
  
  List<TproductStocksDailyEntity> findByStockIdOrderByIdDesc(Long stockId);  

  List<TproductStocksDailyEntity> findByStockIdOrderByTradeDateAsc(Long stockId);

}
