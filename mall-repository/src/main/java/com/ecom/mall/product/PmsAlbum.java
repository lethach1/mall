package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pms_album")
public class PmsAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Size(max = 1000)
    @Column(name = "cover_pic", length = 1000)
    private String coverPic;

    @Column(name = "pic_count")
    private Integer picCount;

    @Column(name = "sort")
    private Integer sort;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

}