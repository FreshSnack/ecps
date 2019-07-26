package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.User;
import com.ahnu.ecps.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务类
 * @Author: mxding
 * @Date: 2019-07-24 10:29
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }
}
