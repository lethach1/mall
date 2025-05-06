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
@Table(name = "ums_resource")
public class UmsResource {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 200)
    @Column(name = "name", length = 200)
    private String name;

    @Size(max = 200)
    @Column(name = "url", length = 200)
    private String url;

    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "category_id")
    private Long categoryId;

}