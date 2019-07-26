package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色数据接口
 * @Author: mxding
 * @Date: 2019-07-24 10:23
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
