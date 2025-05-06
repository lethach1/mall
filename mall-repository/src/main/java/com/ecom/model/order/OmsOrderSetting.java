package com.ecom.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "oms_order_setting")
public class OmsOrderSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "flash_order_overtime")
    private Integer flashOrderOvertime;

    @Column(name = "normal_order_overtime")
    private Integer normalOrderOvertime;

    @Column(name = "confirm_overtime")
    private Integer confirmOvertime;

    @Column(name = "finish_overtime")
    private Integer finishOvertime;

    @Column(name = "comment_overtime")
    private Integer commentOvertime;

}