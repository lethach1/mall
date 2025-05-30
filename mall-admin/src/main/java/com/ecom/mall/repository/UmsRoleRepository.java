package com.ecom.mall.repository;

import com.ecom.mall.user.UmsMenu;
import com.ecom.mall.user.UmsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsRoleRepository extends JpaRepository<UmsRole, Long> {

//    @Query( value =
//            """ SELECT
//                m.id id,
//                m.parent_id parentId,
//                m.create_time createTime,
//                m.title title,
//                m.level level,
//                m.sort sort,
//                m.name name,
//                m.icon icon,
//                m.hidden hidden
//            FROM
//                ums_admin_role_relation arr
//                    LEFT JOIN ums_role r ON arr.role_id = r.id
//                    LEFT JOIN ums_role_menu_relation rmr ON r.id = rmr.role_id
//                    LEFT JOIN ums_menu m ON rmr.menu_id = m.id
//            WHERE
//                arr.admin_id = :adminId
//              AND m.id IS NOT NULL
//            GROUP BY
//                m.id """, nativeQuery = true
//    )
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
