package com.ecom.mall.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ums_admin")
public class UmsAdmin {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 64)
    @Column(name = "username", length = 64)
    private String username;

    @Size(max = 64)
    @Column(name = "password", length = 64)
    private String password;

    @Size(max = 500)
    @Column(name = "icon", length = 500)
    private String icon;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 200)
    @Column(name = "nick_name", length = 200)
    private String nickName;

    @Size(max = 500)
    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "login_time")
    private Instant loginTime;

    @ColumnDefault("1")
    @Column(name = "status")
    private Integer status;

}