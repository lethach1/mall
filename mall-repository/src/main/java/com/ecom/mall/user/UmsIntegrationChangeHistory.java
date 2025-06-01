package com.ecom.mall.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ums_integration_change_history")
public class UmsIntegrationChangeHistory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "change_type")
    private Integer changeType;

    @Column(name = "change_count")
    private Integer changeCount;

    @Size(max = 100)
    @Column(name = "operate_man", length = 100)
    private String operateMan;

    @Size(max = 200)
    @Column(name = "operate_note", length = 200)
    private String operateNote;

    @Column(name = "source_type")
    private Integer sourceType;

}