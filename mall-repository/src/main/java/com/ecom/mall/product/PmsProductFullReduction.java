package com.ecom.mall.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pms_product_full_reduction")
public class PmsProductFullReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "full_price", precision = 10, scale = 2)
    private BigDecimal fullPrice;

    @Column(name = "reduce_price", precision = 10, scale = 2)
    private BigDecimal reducePrice;

}