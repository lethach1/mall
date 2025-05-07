package com.ecom.config;

import com.ecom.component.DynamicAuthorizationManager;
import com.ecom.component.JwtAuthenticationTokenFilter;
import com.ecom.component.RestAuthenticationEntryPoint;
import com.ecom.component.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired(required = false)
    private DynamicAuthorizationManager dynamicAuthorizationManager;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(registry -> {
                    //Được phép truy cập vào các đường dẫn tài nguyên không yêu cầu bảo vệ
                    for (String url : ignoreUrlsConfig.getUrls()) {
                        registry.requestMatchers(url).permitAll();
                    }
                    // Cho phép tất cả các yêu cầu HTTP OPTIONS (preflight) để xử lý CORS
                    registry.requestMatchers(HttpMethod.OPTIONS).permitAll();
                })
                //Bất kỳ yêu cầu nào cũng cần xác thực
                .authorizeHttpRequests(registry-> registry.anyRequest()
                        //Thêm trình quản lý quyền động khi có cấu hình quyền trên database
                        .access(dynamicAuthorizationManager==null? AuthenticatedAuthorizationManager.authenticated():dynamicAuthorizationManager)
                )
                //vô hiệu csrf
                .csrf(AbstractHttpConfigurer::disable)
                //Thay đổi chiến lược tạo session thành 'phi trạng thái' (stateless) STATELESS nghĩa là không sử dụng HTTP Session để lưu trạng thái đăng nhập.
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //Config class xử lý khi bị từ chối quyền truy cập
                .exceptionHandling(configurer -> configurer.accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthenticationEntryPoint))
                //Thêm bộ lọc JWT tùy biến để chặn và xác thực quyền truy cập
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}
