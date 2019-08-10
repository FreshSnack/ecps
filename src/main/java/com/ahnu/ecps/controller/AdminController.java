package com.ahnu.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin权限控制器
 * @author dingmx
 * @date 2019/8/9 22:33
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 课程介绍
     * @return
     */
    @RequestMapping(value = "/introduction")
    public String introduction() {
        return "admin/introduction";
    }

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
    public String guest() {
        return "admin/guest";
    }

    /**
     * 地貌图片
     * @return
     */
    @RequestMapping(value = "/picture")
    public String picture() {
        return "admin/picture";
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
     * 申报书
     * @return
     */
    @RequestMapping(value = "/apply")
    public String apply() {
        return "admin/apply";
    }

    /**
     * 教学反馈
     * @return
     */
    @RequestMapping(value = "/feedback")
    public String feedback() {
        return "admin/feedback";
    }


    /**
     * 试题库
     * @return
     */
    @RequestMapping(value = "/library")
    public String library() {
        return "admin/library";
    }

    /**
     * 教学大纲
     * @return
     */
    @RequestMapping(value = "/outline")
    public String outline() {
        return "admin/outline";
    }

    /**
     * 授课教案
     * @return
     */
    @RequestMapping(value = "/plan")
    public String plan() {
        return "admin/plan";
    }

    /**
     * 教学团队
     * @return
     */
    @RequestMapping(value = "/team")
    public String team() {
        return "admin/team";
    }

    /**
     * 教学视频
     * @return
     */
    @RequestMapping(value = "/video")
    public String video() {
        return "admin/video";
    }

    /**
     * 教学课件
     * @return
     */
    @RequestMapping(value = "/ware")
    public String ware() {
        return "admin/ware";
    }
}