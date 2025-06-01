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
@Table(name = "ums_resource_category")
public class UmsResourceCategory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 200)
    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "sort")
    private Integer sort;

}