package com.ecom.mall.service;

import com.ecom.mall.user.UmsMenu;
import com.ecom.mall.user.UmsResource;
import com.ecom.mall.user.UmsRole;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UmsRoleService {
    void create(UmsRole role);

    int update(Long id, UmsRole role);

    int delete(List<Long> ids);

    /* get list roles */
    List<UmsRole> list();

    /* Get list roles theo trang (có phân trang và tìm kiếm theo từ khóa) */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /* Lấy danh sách menu tương ứng với ID quản trị viên */
    List<UmsMenu> getMenuList(Long adminId);

    /* Lấy danh sách menu ứng với từng role */
    List<UmsMenu> listMenu(Long roleId);

    /* Lấy danh sách resource ứng với từng role */
    List<UmsResource> listResource(Long roleId);

    /* Phân bổ menu cho từng role */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /* Phân bổ resource cho từng role */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
