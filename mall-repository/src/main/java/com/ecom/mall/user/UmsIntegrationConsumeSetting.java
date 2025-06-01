package com.ecom.mall.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ums_integration_consume_setting")
public class UmsIntegrationConsumeSetting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "deduction_per_amount")
    private Integer deductionPerAmount;

    @Column(name = "max_percent_per_order")
    private Integer maxPercentPerOrder;

    @Column(name = "use_unit")
    private Integer useUnit;

    @Column(name = "coupon_status")
    private Integer couponStatus;

}