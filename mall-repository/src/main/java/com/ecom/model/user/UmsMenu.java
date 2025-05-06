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
@Table(name = "ums_menu")
public class UmsMenu {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "level")
    private Integer level;

    @Column(name = "sort")
    private Integer sort;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 200)
    @Column(name = "icon", length = 200)
    private String icon;

    @Column(name = "hidden")
    private Integer hidden;

}