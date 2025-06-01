package com.ecom.mall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UmsAdminParam {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @Email
    private String email;

    private String nickName;

    private String note;
}
