package com.ecom.model.configure;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cms_prefrence_area")
public class CmsPrefrenceArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "sub_title")
    private String subTitle;

    @Size(max = 500)
    @Column(name = "pic", length = 500)
    private String pic;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "show_status")
    private Integer showStatus;

}