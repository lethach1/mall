package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pms_product_attribute")
public class PmsProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "select_type")
    private Integer selectType;

    @Column(name = "input_type")
    private Integer inputType;

    @Size(max = 255)
    @Column(name = "input_list")
    private String inputList;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "filter_type")
    private Integer filterType;

    @Column(name = "search_type")
    private Integer searchType;

    @Column(name = "related_status")
    private Integer relatedStatus;

    @Column(name = "hand_add_status")
    private Integer handAddStatus;

    @Column(name = "type")
    private Integer type;

}