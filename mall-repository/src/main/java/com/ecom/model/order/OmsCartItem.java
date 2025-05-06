package com.ecom.model.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "oms_cart_item")
public class OmsCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_sku_id")
    private Long productSkuId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Size(max = 1000)
    @Column(name = "product_pic", length = 1000)
    private String productPic;

    @Size(max = 500)
    @Column(name = "product_name", length = 500)
    private String productName;

    @Size(max = 500)
    @Column(name = "product_sub_title", length = 500)
    private String productSubTitle;

    @Size(max = 200)
    @Column(name = "product_sku_code", length = 200)
    private String productSkuCode;

    @Size(max = 500)
    @Column(name = "member_nickname", length = 500)
    private String memberNickname;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @ColumnDefault("0")
    @Column(name = "delete_status")
    private Integer deleteStatus;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Size(max = 200)
    @Column(name = "product_brand", length = 200)
    private String productBrand;

    @Size(max = 200)
    @Column(name = "product_sn", length = 200)
    private String productSn;

    @Size(max = 500)
    @Column(name = "product_attr", length = 500)
    private String productAttr;

}