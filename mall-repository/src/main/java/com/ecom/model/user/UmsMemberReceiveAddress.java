package com.ecom.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ums_member_receive_address")
public class UmsMemberReceiveAddress {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 64)
    @Column(name = "phone_number", length = 64)
    private String phoneNumber;

    @Column(name = "default_status")
    private Integer defaultStatus;

    @Size(max = 100)
    @Column(name = "post_code", length = 100)
    private String postCode;

    @Size(max = 100)
    @Column(name = "province", length = 100)
    private String province;

    @Size(max = 100)
    @Column(name = "city", length = 100)
    private String city;

    @Size(max = 100)
    @Column(name = "region", length = 100)
    private String region;

    @Size(max = 128)
    @Column(name = "detail_address", length = 128)
    private String detailAddress;

}