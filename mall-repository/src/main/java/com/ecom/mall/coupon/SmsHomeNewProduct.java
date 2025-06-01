package com.ecom.mall.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sms_home_new_product")
public class SmsHomeNewProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 500)
    @Column(name = "product_name", length = 500)
    private String productName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    @Column(name = "sort")
    private Integer sort;

}