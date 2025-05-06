package com.ecom.model.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cms_member_report")
public class CmsMemberReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_type")
    private Integer reportType;

    @Size(max = 100)
    @Column(name = "report_member_name", length = 100)
    private String reportMemberName;

    @Column(name = "create_time")
    private Instant createTime;

    @Size(max = 100)
    @Column(name = "report_object", length = 100)
    private String reportObject;

    @Column(name = "report_status")
    private Integer reportStatus;

    @Column(name = "handle_status")
    private Integer handleStatus;

    @Size(max = 200)
    @Column(name = "note", length = 200)
    private String note;

}