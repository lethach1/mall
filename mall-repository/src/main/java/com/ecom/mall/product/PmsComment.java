package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pms_comment")
public class PmsComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 255)
    @Column(name = "member_nick_name")
    private String memberNickName;

    @Size(max = 255)
    @Column(name = "product_name")
    private String productName;

    @Column(name = "star")
    private Integer star;

    @Size(max = 64)
    @Column(name = "member_ip", length = 64)
    private String memberIp;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "show_status")
    private Integer showStatus;

    @Size(max = 255)
    @Column(name = "product_attribute")
    private String productAttribute;

    @Column(name = "collect_couont")
    private Integer collectCouont;

    @Column(name = "read_count")
    private Integer readCount;

    @Lob
    @Column(name = "content")
    private String content;

    @Size(max = 1000)
    @Column(name = "pics", length = 1000)
    private String pics;

    @Size(max = 255)
    @Column(name = "member_icon")
    private String memberIcon;

    @Column(name = "replay_count")
    private Integer replayCount;

}