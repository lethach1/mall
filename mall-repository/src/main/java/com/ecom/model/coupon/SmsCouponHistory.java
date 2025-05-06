package com.ecom.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sms_coupon_history")
public class SmsCouponHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "member_id")
    private Long memberId;

    @Size(max = 64)
    @Column(name = "coupon_code", length = 64)
    private String couponCode;

    @Size(max = 64)
    @Column(name = "member_nickname", length = 64)
    private String memberNickname;

    @Column(name = "get_type")
    private Integer getType;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "use_status")
    private Integer useStatus;

    @Column(name = "use_time")
    private Instant useTime;

    @Column(name = "order_id")
    private Long orderId;

    @Size(max = 100)
    @Column(name = "order_sn", length = 100)
    private String orderSn;

}