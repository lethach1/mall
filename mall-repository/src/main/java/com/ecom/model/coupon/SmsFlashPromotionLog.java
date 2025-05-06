package com.ecom.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sms_flash_promotion_log")
public class SmsFlashPromotionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 64)
    @Column(name = "member_phone", length = 64)
    private String memberPhone;

    @Size(max = 100)
    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "subscribe_time")
    private Instant subscribeTime;

    @Column(name = "send_time")
    private Instant sendTime;

}