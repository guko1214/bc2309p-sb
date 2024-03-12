package com.vtxlab.bootcamp.bcproductdata.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bcproductdata.entity.CoinsIdEntity;

@Repository
public interface CoinsIdEntityRepository extends JpaRepository<CoinsIdEntity, Long>{
  
}
