package com.vtxlab.bootcamp.bcproductdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tproduct_coin_list")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TproductCoinListEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "coin_code")
  private String coinCode;
  
  // @OneToOne(mappedBy = "tproduct_coin_list", cascade = CascadeType.ALL, orphanRemoval = true)
  // @JsonManagedReference
  // private TproductCoinsEntity tproductCoinsEntity = new TproductCoinsEntity();

}
