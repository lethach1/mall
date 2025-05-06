package com.ecom.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pms_feight_template")
public class PmsFeightTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "charge_type")
    private Integer chargeType;

    @Column(name = "first_weight", precision = 10, scale = 2)
    private BigDecimal firstWeight;

    @Column(name = "first_fee", precision = 10, scale = 2)
    private BigDecimal firstFee;

    @Column(name = "continue_weight", precision = 10, scale = 2)
    private BigDecimal continueWeight;

    @Column(name = "continme_fee", precision = 10, scale = 2)
    private BigDecimal continmeFee;

    @Size(max = 255)
    @Column(name = "dest")
    private String dest;

}