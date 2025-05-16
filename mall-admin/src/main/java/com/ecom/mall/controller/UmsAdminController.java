package com.ecom.mall.controller;

import com.ecom.mall.common.api.CommonResult;
import com.ecom.mall.service.UmsAdminService;
import com.ecom.mall.user.UmsAdmin;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class UmsAdminController {

    private String tokenHeader;

    private String tokenHead;

    @Autowired
    private UmsAdminService umsAdminService;

    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@RequestBody){

    }
}
