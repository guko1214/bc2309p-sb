package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.SkFinnhubQuoteEntity;

public interface SkFinnhubQuoteEntityRepository extends JpaRepository<SkFinnhubQuoteEntity,Long> {
  
}
