package com.ecom.mall.service;

import com.ecom.mall.dto.UmsAdminParam;
import com.ecom.mall.user.UmsAdmin;
import com.ecom.mall.user.UmsResource;
import com.ecom.mall.user.UmsRole;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UmsAdminService {
    /**
     * Truy xuất một UmsAdmin từ hệ thống thông qua username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Đăng ký một người quản trị mới với thông tin từ UmsAdminParam
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * Xác thực người dùng và tạo token JWT để dùng trong các lần truy cập sau.
     * @return – Trả về token JWT được tạo
     */
    String login(String username,String password);

    /**
     * Cấp phát token mới khi token cũ gần hết hạn.
     */
    String refreshToken(String oldToken);

    /**
     * Truy vấn thông tin của một quản trị viên theo id
     */
    UmsAdmin getItem(Long id);

    /**
     * Trả về danh sách UmsAdmin theo keyword và phân trang
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Xóa một quản trị viên theo id
     */
    int update(Long id, UmsAdmin admin);

    /**
     * Xoá người dùng được chỉ định
     */
    int delete(Long id);

    /**
     * Gán lại danh sách vai trò (roles) cho quản trị viên.
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * Lấy các vai trò tương ứng của một quản trị viên.
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * Trả về các quyền truy cập (API, trang, chức năng...) của người dùng.
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * Cho phép người quản trị thay đổi mật khẩu hiện tại.
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * Dùng trong quá trình xác thực, trả về UserDetails (thường dùng trong Spring Security).
     */
    UserDetails loadUserByUsername(String username);

    /**
     * Trả về UmsAdminCacheService – một lớp xử lý lưu cache cho admin, ví dụ Redis cache.
     */
    UmsAdminCacheService getCacheService();

    /**
     * Xóa token hoặc session để ngắt kết nối người dùng khỏi hệ thống.
     */
    void logout(String username);
}
