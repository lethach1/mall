package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pms_sku_stock")
public class PmsSkuStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 64)
    @NotNull
    @Column(name = "sku_code", nullable = false, length = 64)
    private String skuCode;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @ColumnDefault("0")
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "low_stock")
    private Integer lowStock;

    @Size(max = 255)
    @Column(name = "pic")
    private String pic;

    @Column(name = "sale")
    private Integer sale;

    @Column(name = "promotion_price", precision = 10, scale = 2)
    private BigDecimal promotionPrice;

    @ColumnDefault("0")
    @Column(name = "lock_stock")
    private Integer lockStock;

    @Size(max = 500)
    @Column(name = "sp_data", length = 500)
    private String spData;

}