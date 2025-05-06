package com.ecom.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pms_product_category")
public class PmsProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "product_count")
    private Integer productCount;

    @Size(max = 64)
    @Column(name = "product_unit", length = 64)
    private String productUnit;

    @Column(name = "nav_status")
    private Integer navStatus;

    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "sort")
    private Integer sort;

    @Size(max = 255)
    @Column(name = "icon")
    private String icon;

    @Size(max = 255)
    @Column(name = "keywords")
    private String keywords;

    @Lob
    @Column(name = "description")
    private String description;

}