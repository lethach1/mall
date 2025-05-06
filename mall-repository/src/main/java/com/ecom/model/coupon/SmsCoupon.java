package com.ecom.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sms_coupon")
public class SmsCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private Integer type;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "platform")
    private Integer platform;

    @Column(name = "count")
    private Integer count;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "per_limit")
    private Integer perLimit;

    @Column(name = "min_point", precision = 10, scale = 2)
    private BigDecimal minPoint;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "use_type")
    private Integer useType;

    @Size(max = 200)
    @Column(name = "note", length = 200)
    private String note;

    @Column(name = "publish_count")
    private Integer publishCount;

    @Column(name = "use_count")
    private Integer useCount;

    @Column(name = "receive_count")
    private Integer receiveCount;

    @Column(name = "enable_time")
    private Instant enableTime;

    @Size(max = 64)
    @Column(name = "code", length = 64)
    private String code;

    @Column(name = "member_level")
    private Integer memberLevel;

}