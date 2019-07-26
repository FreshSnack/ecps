package com.ahnu.ecps.config;

import com.ahnu.ecps.domain.Role;
import com.ahnu.ecps.domain.User;
import com.ahnu.ecps.service.IUserService;
import com.ahnu.ecps.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义身份认证
 * @Author: mxding
 * @Date: 2019-07-24 09:48
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 根据用户名获取用户信息
        User user = userService.getByUserName(token.getUsername());
        if(user == null) {
            throw new AccountException("用户不存在");
        }
        String password = user.getPassword();
        if(StringUtils.isNullString(password) || !password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        User user = userService.getByUserName(username);
        List<Role> roleList = user.getRoleList();
        Set<String> set = new HashSet<>();
        roleList.forEach(role -> set.add(role.getCode()));
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }
}
