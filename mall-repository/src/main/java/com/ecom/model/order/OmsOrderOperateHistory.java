package com.ecom.model.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "oms_order_operate_history")
public class OmsOrderOperateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Size(max = 100)
    @Column(name = "operate_man", length = 100)
    private String operateMan;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Size(max = 500)
    @Column(name = "note", length = 500)
    private String note;

}