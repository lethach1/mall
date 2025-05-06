package com.ecom.model.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cms_topic")
public class CmsTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "attend_count")
    private Integer attendCount;

    @Column(name = "attention_count")
    private Integer attentionCount;

    @Column(name = "read_count")
    private Integer readCount;

    @Size(max = 100)
    @Column(name = "award_name", length = 100)
    private String awardName;

    @Size(max = 100)
    @Column(name = "attend_type", length = 100)
    private String attendType;

    @Lob
    @Column(name = "content")
    private String content;

}