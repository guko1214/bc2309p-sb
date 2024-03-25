package com.vtxlab.bootcamp.bcproductdata.repostitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TexCPCoingeckoMKEntity;

public interface TexCPCoingeckoMKEntityRepository extends JpaRepository<TexCPCoingeckoMKEntity,Long> {
  
  List<TexCPCoingeckoMKEntity> findByQuoteCoinCodeOrderByIdDesc(String d);

}
