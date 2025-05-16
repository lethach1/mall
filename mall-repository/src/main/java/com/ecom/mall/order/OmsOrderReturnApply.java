package com.ecom.mall.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "oms_order_return_apply")
public class OmsOrderReturnApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "company_address_id")
    private Long companyAddressId;

    @Column(name = "product_id")
    private Long productId;

    @Size(max = 64)
    @Column(name = "order_sn", length = 64)
    private String orderSn;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 64)
    @Column(name = "member_username", length = 64)
    private String memberUsername;

    @Column(name = "return_amount", precision = 10, scale = 2)
    private BigDecimal returnAmount;

    @Size(max = 100)
    @Column(name = "return_name", length = 100)
    private String returnName;

    @Size(max = 100)
    @Column(name = "return_phone", length = 100)
    private String returnPhone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "handle_time")
    private Instant handleTime;

    @Size(max = 500)
    @Column(name = "product_pic", length = 500)
    private String productPic;

    @Size(max = 200)
    @Column(name = "product_name", length = 200)
    private String productName;

    @Size(max = 200)
    @Column(name = "product_brand", length = 200)
    private String productBrand;

    @Size(max = 500)
    @Column(name = "product_attr", length = 500)
    private String productAttr;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "product_price", precision = 10, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "product_real_price", precision = 10, scale = 2)
    private BigDecimal productRealPrice;

    @Size(max = 200)
    @Column(name = "reason", length = 200)
    private String reason;

    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;

    @Size(max = 1000)
    @Column(name = "proof_pics", length = 1000)
    private String proofPics;

    @Size(max = 500)
    @Column(name = "handle_note", length = 500)
    private String handleNote;

    @Size(max = 100)
    @Column(name = "handle_man", length = 100)
    private String handleMan;

    @Size(max = 100)
    @Column(name = "receive_man", length = 100)
    private String receiveMan;

    @Column(name = "receive_time")
    private Instant receiveTime;

    @Size(max = 500)
    @Column(name = "receive_note", length = 500)
    private String receiveNote;

}