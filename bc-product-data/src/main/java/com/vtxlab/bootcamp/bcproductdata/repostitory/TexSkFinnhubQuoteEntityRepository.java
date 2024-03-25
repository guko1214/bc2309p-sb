package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.bootcamp.bcproductdata.entity.TexSkFinnhubQuoteEntity;
import java.util.List;


public interface TexSkFinnhubQuoteEntityRepository extends JpaRepository<TexSkFinnhubQuoteEntity,Long> {
 
  List<TexSkFinnhubQuoteEntity> findByQuoteStockCodeOrderByIdDesc(String quoteStockCode);

}
