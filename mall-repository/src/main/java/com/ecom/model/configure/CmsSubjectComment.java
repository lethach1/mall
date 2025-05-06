package com.ecom.model.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cms_subject_comment")
public class CmsSubjectComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Size(max = 255)
    @Column(name = "member_nick_name")
    private String memberNickName;

    @Size(max = 255)
    @Column(name = "member_icon")
    private String memberIcon;

    @Size(max = 1000)
    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "show_status")
    private Integer showStatus;

}