package com.ecom.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "pms_product_attribute_category")
public class PmsProductAttributeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @ColumnDefault("0")
    @Column(name = "attribute_count")
    private Integer attributeCount;

    @ColumnDefault("0")
    @Column(name = "param_count")
    private Integer paramCount;

}