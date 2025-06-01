package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_old", precision = 10, scale = 2)
    private BigDecimal priceOld;

    @Column(name = "price_new", precision = 10, scale = 2)
    private BigDecimal priceNew;

    @Column(name = "sale_price_old", precision = 10, scale = 2)
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new", precision = 10, scale = 2)
    private BigDecimal salePriceNew;

    @Column(name = "gift_point_old")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    private Integer usePointLimitNew;

    @Size(max = 64)
    @Column(name = "operate_man", length = 64)
    private String operateMan;

    @Column(name = "create_time")
    private Instant createTime;

}