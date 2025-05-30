package com.ecom.mall.service.impl;

import com.ecom.mall.repository.UmsRoleRepository;
import com.ecom.mall.service.UmsRoleService;
import com.ecom.mall.user.UmsMenu;
import com.ecom.mall.user.UmsResource;
import com.ecom.mall.user.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    UmsRoleRepository roleRepository;

    @Override
    public void create(UmsRole role) {
        role.setCreateTime(Instant.now());
        role.setAdminCount(0);
        role.setSort(0);
        roleRepository.save(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        return 0;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public List<UmsRole> list() {
        return List.of();
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        return List.of();
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleRepository.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return List.of();
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return List.of();
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        return 0;
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        return 0;
    }
}
