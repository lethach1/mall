package com.ecom.mall.repository;

import com.ecom.mall.user.UmsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsAdminRepository extends JpaRepository<UmsAdmin, Long> {

    UmsAdmin findByUsername(String username);
}
