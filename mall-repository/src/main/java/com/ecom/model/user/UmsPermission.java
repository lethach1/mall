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
@Table(name = "ums_permission")
public class UmsPermission {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 200)
    @Column(name = "value", length = 200)
    private String value;

    @Size(max = 500)
    @Column(name = "icon", length = 500)
    private String icon;

    @Column(name = "type")
    private Integer type;

    @Size(max = 200)
    @Column(name = "uri", length = 200)
    private String uri;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "sort")
    private Integer sort;

}