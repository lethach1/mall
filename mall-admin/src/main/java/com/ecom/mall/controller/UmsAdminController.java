package com.ecom.mall.controller;

import com.ecom.mall.common.api.CommonResult;
import com.ecom.mall.dto.UmsAdminLoginParam;
import com.ecom.mall.dto.UmsAdminParam;
import com.ecom.mall.service.UmsAdminService;
import com.ecom.mall.service.UmsRoleService;
import com.ecom.mall.user.UmsAdmin;
import com.ecom.mall.user.UmsRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsRoleService umsRoleService;

    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@Validated @RequestBody UmsAdminParam umsAdminParam){
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin != null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @PostMapping("/login")
    public CommonResult<?> login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam){
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("Đăng nhập thất bại");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token); // The actual JWT token
        tokenMap.put("tokenHead",tokenHead);  //Bearer
        return CommonResult.success(tokenMap);
    }

    @GetMapping("/refreshToken")
    public CommonResult<?> refreshToken(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String refreshToken = umsAdminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("Refresh token thất bại！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @GetMapping("/info")
    public CommonResult<?> getAdminInfo(Principal principal){
        if(principal == null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", umsRoleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = umsAdminService.getRoleList(umsAdmin.getId());
        if(roleList !=null && !roleList.isEmpty()){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
    }
}
