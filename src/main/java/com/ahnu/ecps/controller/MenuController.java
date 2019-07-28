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
     * 申报书
     */
    @RequestMapping("/apply")
    public String apply(Model model) {
        model.addAttribute("menu_code", "apply");
        model.addAttribute("apply_count", pvService.getVisitCount("apply"));
        return "menu/apply";
    }

    /**
     * 教学团队
     */
    @RequestMapping("/team")
    public String team(Model model) {
        model.addAttribute("menu_code", "team");
        model.addAttribute("team_count", pvService.getVisitCount("team"));
        return "menu/team";
    }

    /**
     * 教学大纲
     */
    @RequestMapping("/outline")
    public String outline(Model model) {
        model.addAttribute("menu_code", "outline");
        model.addAttribute("outline_count", pvService.getVisitCount("outline"));
        return "menu/outline";
    }

    /**
     * 授课教案
     */
    @RequestMapping("/plan")
    public String plan(Model model) {
        model.addAttribute("menu_code", "plan");
        model.addAttribute("plan_count", pvService.getVisitCount("plan"));
        return "menu/plan";
    }


    /**
     * 教学课件
     */
    @RequestMapping("/ware")
    public String ware(Model model) {
        model.addAttribute("menu_code", "ware");
        model.addAttribute("ware_count", pvService.getVisitCount("ware"));
        return "menu/ware";
    }


    /**
     * 教学视频
     */
    @RequestMapping("/video")
    public String video(Model model) {
        model.addAttribute("menu_code", "video");
        model.addAttribute("video_count", pvService.getVisitCount("video"));
        return "menu/video";
    }


    /**
     * 试题库
     */
    @RequestMapping("/library")
    public String library(Model model) {
        model.addAttribute("menu_code", "library");
        model.addAttribute("library_count", pvService.getVisitCount("library"));
        return "menu/library";
    }

    /**
     * 教学反馈
     */
    @RequestMapping("/feedback")
    public String feedback(Model model) {
        model.addAttribute("menu_code", "feedback");
        model.addAttribute("feedback_count", pvService.getVisitCount("feedback"));
        return "menu/feedback";
    }
}
