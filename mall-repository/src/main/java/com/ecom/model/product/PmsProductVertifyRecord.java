package com.ecom.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pms_product_vertify_record")
public class PmsProductVertifyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 64)
    @Column(name = "vertify_man", length = 64)
    private String vertifyMan;

    @Column(name = "status")
    private Integer status;

    @Size(max = 255)
    @Column(name = "detail")
    private String detail;

}