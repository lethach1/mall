package com.ecom.model.user;

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
@Table(name = "ums_member_login_log")
public class UmsMemberLoginLog {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 64)
    @Column(name = "ip", length = 64)
    private String ip;

    @Size(max = 64)
    @Column(name = "city", length = 64)
    private String city;

    @Column(name = "login_type")
    private Integer loginType;

    @Size(max = 64)
    @Column(name = "province", length = 64)
    private String province;

}