package com.ecom.mall.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cms_help")
public class CmsHelp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Size(max = 500)
    @Column(name = "icon", length = 500)
    private String icon;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "read_count")
    private Integer readCount;

    @Lob
    @Column(name = "content")
    private String content;

}