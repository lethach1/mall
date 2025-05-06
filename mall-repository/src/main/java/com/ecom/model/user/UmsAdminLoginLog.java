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
@Table(name = "ums_admin_login_log")
public class UmsAdminLoginLog {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 64)
    @Column(name = "ip", length = 64)
    private String ip;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(max = 100)
    @Column(name = "user_agent", length = 100)
    private String userAgent;

}