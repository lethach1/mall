package com.ecom.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sms_coupon_product_relation")
public class SmsCouponProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 500)
    @Column(name = "product_name", length = 500)
    private String productName;

    @Size(max = 200)
    @Column(name = "product_sn", length = 200)
    private String productSn;

}