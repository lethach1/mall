package com.ecom.mall.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cms_help_category")
public class CmsHelpCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 500)
    @Column(name = "icon", length = 500)
    private String icon;

    @Column(name = "help_count")
    private Integer helpCount;

    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "sort")
    private Integer sort;

}