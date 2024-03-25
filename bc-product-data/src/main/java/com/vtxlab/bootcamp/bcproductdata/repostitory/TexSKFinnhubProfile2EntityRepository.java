package com.vtxlab.bootcamp.bcproductdata.repostitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSKFinnhubProfile2Entity;

public interface TexSKFinnhubProfile2EntityRepository extends JpaRepository<TexSKFinnhubProfile2Entity,Long> {
  
  List<TexSKFinnhubProfile2Entity> findByQuoteStockCodeOrderByIdDesc(String quoteStockCode);

}

