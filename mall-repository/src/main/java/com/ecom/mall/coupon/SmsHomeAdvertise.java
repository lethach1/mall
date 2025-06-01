package com.ecom.mall.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sms_home_advertise")
public class SmsHomeAdvertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "type")
    private Integer type;

    @Size(max = 500)
    @Column(name = "pic", length = 500)
    private String pic;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "status")
    private Integer status;

    @Column(name = "click_count")
    private Integer clickCount;

    @Column(name = "order_count")
    private Integer orderCount;

    @Size(max = 500)
    @Column(name = "url", length = 500)
    private String url;

    @Size(max = 500)
    @Column(name = "note", length = 500)
    private String note;

    @ColumnDefault("0")
    @Column(name = "sort")
    private Integer sort;

}