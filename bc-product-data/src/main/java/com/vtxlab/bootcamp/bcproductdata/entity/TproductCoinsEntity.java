package com.vtxlab.bootcamp.bcproductdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tproduct_coins")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class TproductCoinsEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "coin_id",unique=true)
  private Long coinId;
  private String name;
  @Column(name = "curr_price")
  private Double currentPrice;
  @Column(name = "price_chg_pct")
  private Double priceChgPct;
  @Column(name = "market_Cap")
  private Double marketCap;
  private String logo;

  // @OneToOne
  // @JoinColumn(name = "coin_id", referencedColumnName = "ID")
  // @JsonBackReference
  // private TproductCoinListEntity tproductCoinList;
}
