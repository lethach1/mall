package com.ecom.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sms_coupon_product_category_relation")
public class SmsCouponProductCategoryRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Size(max = 200)
    @Column(name = "product_category_name", length = 200)
    private String productCategoryName;

    @Size(max = 200)
    @Column(name = "parent_category_name", length = 200)
    private String parentCategoryName;

}