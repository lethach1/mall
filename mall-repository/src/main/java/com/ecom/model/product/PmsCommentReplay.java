package com.ecom.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pms_comment_replay")
public class PmsCommentReplay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

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

    @Column(name = "type")
    private Integer type;

}