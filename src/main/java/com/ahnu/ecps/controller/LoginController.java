package com.ahnu.ecps.controller;

import com.ahnu.ecps.utils.AjaxReturn;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @Author: mxding
 * @Date: 2019-07-24 12:26
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }


    /**
     * 后台管理首页
     * @return
     */
    @RequestMapping(value = "/admin")
    public String index() {
        return "admin/index";
    }

    /**
     * 无权限页面
     * @return
     */
    @RequestMapping(value = "/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public AjaxReturn loginAction(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        return AjaxReturn.success("login success");
    }

    /**
     * 登出
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/logout")
    public AjaxReturn logoutAction() {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 执行登出
        subject.logout();
        return AjaxReturn.success("logout success");
    }
}
