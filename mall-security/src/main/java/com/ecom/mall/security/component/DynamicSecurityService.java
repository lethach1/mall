package com.ecom.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/* vai trò là cầu nối giữa hệ thống bảo mật và nguồn dữ liệu quyền trong database,
* cấu hình bảo mật có thể thay đổi trong thời gian chạy mà không cần khởi động lại ứng dụng. */
public interface DynamicSecurityService {
    /* Tải dữ liệu ánh xạ giữa URL pattern và quyền truy cập tương ứng */
    Map<String, ConfigAttribute> loadDataSource();
}
