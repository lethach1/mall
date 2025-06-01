package com.ecom.mall.service;

import com.ecom.mall.user.UmsAdmin;
import com.ecom.mall.user.UmsResource;

import java.util.List;

public interface UmsAdminCacheService {
    /**
     * Xóa cache thông tin người dùng quản trị (admin)
     */
    void delAdmin(Long adminId);

    /**
     * Xóa cache danh sách tài nguyên (resource) của người dùng quản trị
     */
    void delResourceList(Long adminId);

    /**
     * Khi thông tin tài nguyên liên quan đến vai trò (role) thay đổi, xóa cache người dùng quản trị liên quan
     */
    void delResourceListByRole(Long roleId);

    /**
     * Khi thông tin tài nguyên liên quan đến các vai trò thay đổi, xóa cache người dùng quản trị liên quan
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * Khi thông tin tài nguyên thay đổi, xóa cache danh sách tài nguyên của người dùng quản trị liên quan
     */
    void delResourceListByResource(Long resourceId);

    /**
     * Lấy thông tin người dùng quản trị từ cache
     */
    UmsAdmin getAdmin(String username);

    /**
     * Lưu thông tin người dùng quản trị vào cache
     */
    void setAdmin(UmsAdmin admin);

    /**
     * Lấy danh sách tài nguyên của người dùng quản trị từ cache
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * Lưu danh sách tài nguyên của người dùng quản trị vào cache
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);
}
