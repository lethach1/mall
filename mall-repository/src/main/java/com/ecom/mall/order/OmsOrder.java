package com.ecom.mall.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "oms_order")
public class OmsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Size(max = 64)
    @Column(name = "order_sn", length = 64)
    private String orderSn;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 64)
    @Column(name = "member_username", length = 64)
    private String memberUsername;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "pay_amount", precision = 10, scale = 2)
    private BigDecimal payAmount;

    @Column(name = "freight_amount", precision = 10, scale = 2)
    private BigDecimal freightAmount;

    @Column(name = "promotion_amount", precision = 10, scale = 2)
    private BigDecimal promotionAmount;

    @Column(name = "integration_amount", precision = 10, scale = 2)
    private BigDecimal integrationAmount;

    @Column(name = "coupon_amount", precision = 10, scale = 2)
    private BigDecimal couponAmount;

    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "source_type")
    private Integer sourceType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "order_type")
    private Integer orderType;

    @Size(max = 64)
    @Column(name = "delivery_company", length = 64)
    private String deliveryCompany;

    @Size(max = 64)
    @Column(name = "delivery_sn", length = 64)
    private String deliverySn;

    @Column(name = "auto_confirm_day")
    private Integer autoConfirmDay;

    @Column(name = "integration")
    private Integer integration;

    @Column(name = "growth")
    private Integer growth;

    @Size(max = 100)
    @Column(name = "promotion_info", length = 100)
    private String promotionInfo;

    @Column(name = "bill_type")
    private Integer billType;

    @Size(max = 200)
    @Column(name = "bill_header", length = 200)
    private String billHeader;

    @Size(max = 200)
    @Column(name = "bill_content", length = 200)
    private String billContent;

    @Size(max = 32)
    @Column(name = "bill_receiver_phone", length = 32)
    private String billReceiverPhone;

    @Size(max = 64)
    @Column(name = "bill_receiver_email", length = 64)
    private String billReceiverEmail;

    @Size(max = 100)
    @NotNull
    @Column(name = "receiver_name", nullable = false, length = 100)
    private String receiverName;

    @Size(max = 32)
    @NotNull
    @Column(name = "receiver_phone", nullable = false, length = 32)
    private String receiverPhone;

    @Size(max = 32)
    @Column(name = "receiver_post_code", length = 32)
    private String receiverPostCode;

    @Size(max = 32)
    @Column(name = "receiver_province", length = 32)
    private String receiverProvince;

    @Size(max = 32)
    @Column(name = "receiver_city", length = 32)
    private String receiverCity;

    @Size(max = 32)
    @Column(name = "receiver_region", length = 32)
    private String receiverRegion;

    @Size(max = 200)
    @Column(name = "receiver_detail_address", length = 200)
    private String receiverDetailAddress;

    @Size(max = 500)
    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "confirm_status")
    private Integer confirmStatus;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "delete_status", nullable = false)
    private Integer deleteStatus;

    @Column(name = "use_integration")
    private Integer useIntegration;

    @Column(name = "payment_time")
    private Instant paymentTime;

    @Column(name = "delivery_time")
    private Instant deliveryTime;

    @Column(name = "receive_time")
    private Instant receiveTime;

    @Column(name = "comment_time")
    private Instant commentTime;

    @Column(name = "modify_time")
    private Instant modifyTime;

}