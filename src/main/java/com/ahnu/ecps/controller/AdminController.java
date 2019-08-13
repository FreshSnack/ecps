package com.ahnu.ecps.controller;

import com.ahnu.ecps.service.IGeoPictureService;
import com.ahnu.ecps.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin权限控制器
 * @author dingmx
 * @date 2019/8/9 22:33
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IMessageService messageService;

    /**
     * 教学活动
     * @return
     */
    @RequestMapping(value = "/teaching")
    public String teaching() {
        return "admin/teaching";
    }

    /**
     * 科普园地
     * @return
     */
    @RequestMapping(value = "/knowledge")
    public String knowledge() {
        return "admin/knowledge";
    }
    /**
     * 访客留言
     * @return
     */
    @RequestMapping(value = "/guest")
    public String guest(Model model) {
        model.addAttribute("msg_list", messageService.getMessageList());
        return "admin/guest";
    }

    /**
     * 友情链接
     * @return
     */
    @RequestMapping(value = "/link")
    public String link() {
        return "admin/link";
    }

    /**
     * 教学视频
     * @return
     */
    @RequestMapping(value = "/video")
    public String video() {
        return "admin/video";
    }
}
