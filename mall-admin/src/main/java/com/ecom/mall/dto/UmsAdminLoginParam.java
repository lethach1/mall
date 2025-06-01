package com.ecom.mall.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Thông số đăng nhập của người dùng */
@Data
@EqualsAndHashCode
public class UmsAdminLoginParam {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
