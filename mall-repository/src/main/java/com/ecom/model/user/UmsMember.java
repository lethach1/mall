package com.ecom.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ums_member")
public class UmsMember {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_level_id")
    private Long memberLevelId;

    @Size(max = 64)
    @Column(name = "username", length = 64)
    private String username;

    @Size(max = 64)
    @Column(name = "password", length = 64)
    private String password;

    @Size(max = 64)
    @Column(name = "nickname", length = 64)
    private String nickname;

    @Size(max = 64)
    @Column(name = "phone", length = 64)
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 500)
    @Column(name = "icon", length = 500)
    private String icon;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Size(max = 64)
    @Column(name = "city", length = 64)
    private String city;

    @Size(max = 100)
    @Column(name = "job", length = 100)
    private String job;

    @Size(max = 200)
    @Column(name = "personalized_signature", length = 200)
    private String personalizedSignature;

    @Column(name = "source_type")
    private Integer sourceType;

    @Column(name = "integration")
    private Integer integration;

    @Column(name = "growth")
    private Integer growth;

    @Column(name = "luckey_count")
    private Integer luckeyCount;

    @Column(name = "history_integration")
    private Integer historyIntegration;

}