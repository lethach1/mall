package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pms_member_price")
public class PmsMemberPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_level_id")
    private Long memberLevelId;

    @Column(name = "member_price", precision = 10, scale = 2)
    private BigDecimal memberPrice;

    @Size(max = 100)
    @Column(name = "member_level_name", length = 100)
    private String memberLevelName;

}