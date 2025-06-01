package com.ecom.mall.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ums_member_level")
public class UmsMemberLevel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "growth_point")
    private Integer growthPoint;

    @Column(name = "default_status")
    private Integer defaultStatus;

    @Column(name = "free_freight_point", precision = 10, scale = 2)
    private BigDecimal freeFreightPoint;

    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;

    @Column(name = "priviledge_free_freight")
    private Integer priviledgeFreeFreight;

    @Column(name = "priviledge_sign_in")
    private Integer priviledgeSignIn;

    @Column(name = "priviledge_comment")
    private Integer priviledgeComment;

    @Column(name = "priviledge_promotion")
    private Integer priviledgePromotion;

    @Column(name = "priviledge_member_price")
    private Integer priviledgeMemberPrice;

    @Column(name = "priviledge_birthday")
    private Integer priviledgeBirthday;

    @Size(max = 200)
    @Column(name = "note", length = 200)
    private String note;

}