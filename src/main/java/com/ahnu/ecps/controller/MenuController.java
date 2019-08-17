package com.ahnu.ecps.controller;

import com.ahnu.ecps.service.IMessageService;
import com.ahnu.ecps.service.IPageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单视图映射器
 * @Author: mxding
 * @Date: 2019-07-25 12:41
 */
@Controller
public class MenuController {

    @Autowired
    private IPageViewService pvService;

    @Autowired
    private IMessageService messageService;

    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("pv_count", pvService.getVisitCount("home"));
    }

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("menu_code", "home");
        model.addAttribute("msg_list", messageService.getTopMessageList(4));
        return "menu/home";
    }

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("menu_code", "home");
        model.addAttribute("msg_list", messageService.getTopMessageList(4));
        return "menu/home";
    }

    /**
     * 异步获取消息
     * @param model
     * @return
     */
    @RequestMapping("/async/getMessage")
    public String getMessage(Model model) {
        model.addAttribute("msg_list", messageService.getTopMessageList(4));
        return "menu/home::message";
    }

}
