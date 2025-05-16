package com.ecom.mall.product;

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
@Table(name = "pms_product")
public class PmsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "feight_template_id")
    private Long feightTemplateId;

    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    @Size(max = 200)
    @NotNull
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Size(max = 255)
    @Column(name = "pic")
    private String pic;

    @Size(max = 64)
    @NotNull
    @Column(name = "product_sn", nullable = false, length = 64)
    private String productSn;

    @Column(name = "delete_status")
    private Integer deleteStatus;

    @Column(name = "publish_status")
    private Integer publishStatus;

    @Column(name = "new_status")
    private Integer newStatus;

    @Column(name = "recommand_status")
    private Integer recommandStatus;

    @Column(name = "verify_status")
    private Integer verifyStatus;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "sale")
    private Integer sale;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "promotion_price", precision = 10, scale = 2)
    private BigDecimal promotionPrice;

    @ColumnDefault("0")
    @Column(name = "gift_growth")
    private Integer giftGrowth;

    @ColumnDefault("0")
    @Column(name = "gift_point")
    private Integer giftPoint;

    @Column(name = "use_point_limit")
    private Integer usePointLimit;

    @Size(max = 255)
    @Column(name = "sub_title")
    private String subTitle;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "original_price", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "low_stock")
    private Integer lowStock;

    @Size(max = 16)
    @Column(name = "unit", length = 16)
    private String unit;

    @Column(name = "weight", precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(name = "preview_status")
    private Integer previewStatus;

    @Size(max = 64)
    @Column(name = "service_ids", length = 64)
    private String serviceIds;

    @Size(max = 255)
    @Column(name = "keywords")
    private String keywords;

    @Size(max = 255)
    @Column(name = "note")
    private String note;

    @Size(max = 255)
    @Column(name = "album_pics")
    private String albumPics;

    @Size(max = 255)
    @Column(name = "detail_title")
    private String detailTitle;

    @Lob
    @Column(name = "detail_desc")
    private String detailDesc;

    @Lob
    @Column(name = "detail_html")
    private String detailHtml;

    @Lob
    @Column(name = "detail_mobile_html")
    private String detailMobileHtml;

    @Column(name = "promotion_start_time")
    private Instant promotionStartTime;

    @Column(name = "promotion_end_time")
    private Instant promotionEndTime;

    @Column(name = "promotion_per_limit")
    private Integer promotionPerLimit;

    @Column(name = "promotion_type")
    private Integer promotionType;

    @Size(max = 255)
    @Column(name = "brand_name")
    private String brandName;

    @Size(max = 255)
    @Column(name = "product_category_name")
    private String productCategoryName;

}