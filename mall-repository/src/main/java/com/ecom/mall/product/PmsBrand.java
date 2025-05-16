package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pms_brand")
public class PmsBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Size(max = 8)
    @Column(name = "first_letter", length = 8)
    private String firstLetter;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "factory_status")
    private Integer factoryStatus;

    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "product_comment_count")
    private Integer productCommentCount;

    @Size(max = 255)
    @Column(name = "logo")
    private String logo;

    @Size(max = 255)
    @Column(name = "big_pic")
    private String bigPic;

    @Lob
    @Column(name = "brand_story")
    private String brandStory;

}