package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.User;

/**
 * 用户服务接口
 * @Author: mxding
 * @Date: 2019-07-24 11:04
 */
public interface IUserService {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getByUserName(String username);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
