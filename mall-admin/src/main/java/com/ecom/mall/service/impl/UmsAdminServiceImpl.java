package com.ecom.mall.service.impl;

import com.ecom.mall.dto.UmsAdminParam;
import com.ecom.mall.repository.UmsAdminRepository;
import com.ecom.mall.security.util.JwtTokenUtil;
import com.ecom.mall.security.util.SpringUtil;
import com.ecom.mall.service.UmsAdminCacheService;
import com.ecom.mall.service.UmsAdminService;
import com.ecom.mall.user.UmsAdmin;
import com.ecom.mall.user.UmsResource;
import com.ecom.mall.user.UmsRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminRepository adminRepository;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        //Trước tiên lấy dữ liệu từ cache
        UmsAdmin admin = getCacheService().getAdmin(username);
        if (admin != null) return admin;
        //Nếu trong cache không có thì lấy từ cơ sở dữ liệu.
        UmsAdmin userAdmin = adminRepository.findByUsername(username);
        if (userAdmin != null) {
            //Lưu dữ liệu từ cơ sở dữ liệu vào cache
            getCacheService().setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        return "";
    }

    @Override
    public String refreshToken(String oldToken) {
        return "";
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return null;
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return List.of();
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return List.of();
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return List.of();
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam updatePasswordParam) {
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }

    /*
     Lấy instance của UmsAdminCacheService từ Spring container
     Bean chỉ được tạo khi thực sự cần thiết (khi gọi getCacheService())
     */
    @Override
    public UmsAdminCacheService getCacheService() {
        return SpringUtil.getBean(UmsAdminCacheService.class);
    }

    @Override
    public void logout(String username) {

    }
}
