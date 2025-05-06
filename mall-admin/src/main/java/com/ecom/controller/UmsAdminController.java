package com.ecom.controller;

import com.ecom.common.api.CommonResult;
import com.ecom.model.user.UmsAdmin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class UmsAdminController {

    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(){

    }
}
