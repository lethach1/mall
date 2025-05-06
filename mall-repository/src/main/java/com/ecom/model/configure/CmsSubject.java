package com.ecom.model.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cms_subject")
public class CmsSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @Size(max = 500)
    @Column(name = "pic", length = 500)
    private String pic;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "collect_count")
    private Integer collectCount;

    @Column(name = "read_count")
    private Integer readCount;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Size(max = 1000)
    @Column(name = "album_pics", length = 1000)
    private String albumPics;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "show_status")
    private Integer showStatus;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "forward_count")
    private Integer forwardCount;

    @Size(max = 200)
    @Column(name = "category_name", length = 200)
    private String categoryName;

}