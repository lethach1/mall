package com.ecom.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ums_member_rule_setting")
public class UmsMemberRuleSetting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "continue_sign_day")
    private Integer continueSignDay;

    @Column(name = "continue_sign_point")
    private Integer continueSignPoint;

    @Column(name = "consume_per_point", precision = 10, scale = 2)
    private BigDecimal consumePerPoint;

    @Column(name = "low_order_amount", precision = 10, scale = 2)
    private BigDecimal lowOrderAmount;

    @Column(name = "max_point_per_order")
    private Integer maxPointPerOrder;

    @Column(name = "type")
    private Integer type;

}