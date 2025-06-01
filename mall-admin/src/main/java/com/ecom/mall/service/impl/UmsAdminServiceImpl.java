package com.ecom.mall.service.impl;

import com.ecom.mall.common.exception.Asserts;
import com.ecom.mall.common.util.RequestUtil;
import com.ecom.mall.dto.UmsAdminParam;
import com.ecom.mall.repository.UmsAdminLoginLogRepository;
import com.ecom.mall.repository.UmsAdminRepository;
import com.ecom.mall.security.util.JwtTokenUtil;
import com.ecom.mall.security.util.SpringUtil;
import com.ecom.mall.service.UmsAdminCacheService;
import com.ecom.mall.service.UmsAdminService;
import com.ecom.mall.user.UmsAdmin;
import com.ecom.mall.user.UmsAdminLoginLog;
import com.ecom.mall.user.UmsResource;
import com.ecom.mall.user.UmsRole;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
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
    private UmsAdminLoginLogRepository loginLogRepository;

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
        umsAdmin.setCreateTime(Instant.now());
        umsAdmin.setStatus(1);
        //Kiểm tra xem có người dùng nào có cùng tên người dùng không
        UmsAdmin userAdmin = adminRepository.findByUsername(umsAdmin.getUsername());
        if (userAdmin != null) {
            return null;
        }
        //Mã hóa mật khẩu
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminRepository.save(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //Mật khẩu cần được mã hóa bởi clients
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())){
                Asserts.fail("Mật khẩu không chính xác");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("Tài khoản đã bị vô hiệu hóa");
            }

           /* userDetails: Chứa thông tin người dùng đã được xác thực
            null: Đại diện cho credentials (password, nhưng không cần thiết sau khi xác thực)
            userDetails.getAuthorities(): Lấy danh sách quyền (roles) của người dùng */
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("Lỗi đăng nhập:{}", e.getMessage());
        }
        return token;
    }

    /* Thêm bản ghi đăng nhập */
    private void insertLoginLog(String username){
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(Instant.now());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(RequestUtil.getRequestIp(request));
        loginLogRepository.save(loginLog);
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
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
