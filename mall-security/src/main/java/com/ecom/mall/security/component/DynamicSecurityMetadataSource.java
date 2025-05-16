package com.ecom.mall.security.component;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, ConfigAttribute> configAttributeMap = null;
    //để ngăn chặn thay đổi tham chiếu nhưng có thể load lại giá trị dc
    private final DynamicSecurityService dynamicSecurityService;

    // Sử dụng constructor injection thay vì @Autowired
    public DynamicSecurityMetadataSource(DynamicSecurityService dynamicSecurityService) {
        this.dynamicSecurityService = dynamicSecurityService;
        // Thực hiện khởi tạo ngay trong constructor
        this.loadDataSource();
    }

    // cho phép tải lại cấu hình bảo mật mà ko cần khởi tạo lại đối tượng
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    //xóa dữ liệu và đặt tham chiếu về null
    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //Nhận đường dẫn hiện đang được truy cập
        String url = ((FilterInvocation) object).getRequestUrl();
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(url).build();
        String path = uriComponents.getPath();  // chỉ lấy phần path
        return getConfigAttributesWithPath(path);
    }

    //Nhận các quyền tương ứng theo đường dẫn hiện đang được truy cập
    public List<ConfigAttribute> getConfigAttributesWithPath(String path) {
        if (configAttributeMap == null) this.loadDataSource();
        List<ConfigAttribute>  configAttributes = new ArrayList<>();
        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = configAttributeMap.keySet().iterator();
        //Nhận các tài nguyên cần thiết để truy cập đường dẫn
        while (iterator.hasNext()) {
            String pattern = iterator.next();
            if (pathMatcher.match(pattern, path)) {
                configAttributes.add(configAttributeMap.get(pattern));
            }
        }
        // Quyền yêu cầu hoạt động không được thiết lập và một bộ sưu tập trống được trả về
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return List.of();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
