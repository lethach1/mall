package com.ecom.mall.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sms_home_brand")
public class SmsHomeBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Size(max = 64)
    @Column(name = "brand_name", length = 64)
    private String brandName;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    @Column(name = "sort")
    private Integer sort;

}