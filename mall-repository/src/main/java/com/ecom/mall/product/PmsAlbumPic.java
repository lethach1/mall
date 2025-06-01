package com.ecom.mall.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pms_album_pic")
public class PmsAlbumPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "album_id")
    private Long albumId;

    @Size(max = 1000)
    @Column(name = "pic", length = 1000)
    private String pic;

}