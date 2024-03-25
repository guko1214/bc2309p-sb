package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bcproductdata.entity.TproductStocksEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TproductStocksEntityRepository extends JpaRepository<TproductStocksEntity,Long> {
  
  List<TproductStocksEntity> findByStockIdOrderByIdDesc(Long stockId);

}
