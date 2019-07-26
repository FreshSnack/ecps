package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据接口
 * @Author: mxding
 * @Date: 2019-07-24 10:23
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名拿到用户
     * @param username
     * @return
     */
    User getByUsername(String username);
}
