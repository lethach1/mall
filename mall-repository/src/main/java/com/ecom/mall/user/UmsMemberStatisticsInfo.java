package com.ecom.mall.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ums_member_statistics_info")
public class UmsMemberStatisticsInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "consume_amount", precision = 10, scale = 2)
    private BigDecimal consumeAmount;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "coupon_count")
    private Integer couponCount;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "return_order_count")
    private Integer returnOrderCount;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column(name = "attend_count")
    private Integer attendCount;

    @Column(name = "fans_count")
    private Integer fansCount;

    @Column(name = "collect_product_count")
    private Integer collectProductCount;

    @Column(name = "collect_subject_count")
    private Integer collectSubjectCount;

    @Column(name = "collect_topic_count")
    private Integer collectTopicCount;

    @Column(name = "collect_comment_count")
    private Integer collectCommentCount;

    @Column(name = "invite_friend_count")
    private Integer inviteFriendCount;

    @Column(name = "recent_order_time")
    private Instant recentOrderTime;

}