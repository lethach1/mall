package com.ecom.model.coupon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "sms_flash_promotion_product_relation")
public class SmsFlashPromotionProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "flash_promotion_id")
    private Long flashPromotionId;

    @Column(name = "flash_promotion_session_id")
    private Long flashPromotionSessionId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "flash_promotion_price", precision = 10, scale = 2)
    private BigDecimal flashPromotionPrice;

    @Column(name = "flash_promotion_count")
    private Integer flashPromotionCount;

    @Column(name = "flash_promotion_limit")
    private Integer flashPromotionLimit;

    @Column(name = "sort")
    private Integer sort;

}