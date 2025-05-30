package com.ecom.mall.repository;

import com.ecom.mall.user.UmsAdminLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminLoginLogRepository extends JpaRepository<UmsAdminLoginLog, Long> {
}
