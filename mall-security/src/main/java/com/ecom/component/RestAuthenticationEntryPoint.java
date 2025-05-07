package com.ecom.component;

import com.ecom.common.api.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/* xử lý các trường hợp khi người dùng cố gắng truy cập vào tài nguyên
được bảo vệ mà không có xác thực hợp lệ (chưa đăng nhập hoặc token hết hạn). */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public RestAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /* Phương thức này được gọi khi người dùng chưa xác thực cố gắng truy cập tài nguyên được bảo vệ */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(objectMapper.writeValueAsString(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}