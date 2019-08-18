package com.ahnu.ecps.controller;

import com.ahnu.ecps.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 * @author dingmx
 * @date 2019/8/17 23:16
 */
@Controller
public class HomeController {


    @Autowired
    private IPageViewService pvService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IGeoPictureService pictureService;

    @Autowired
    private ILinkService linkService;

    @Autowired
    private IIntroduceService introduceService;

    @Autowired
    private ITeachingService teachingService;

    @Autowired
    private IKnowledgeService knowledgeService;

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping({"/", "/home"})
    public String index(Model model) {
        model.addAttribute("menu_code", "home");
        model.addAttribute("pv_count", pvService.getVisitCount("home"));
        model.addAttribute("msg_list", messageService.getTopMessageList(4));
        model.addAttribute("pic_list", pictureService.listGeoPicture());
        model.addAttribute("link_list", linkService.listLink());
        model.addAttribute("introduce", introduceService.getIntroduce());
        model.addAttribute("teaching_list", teachingService.listTopTeaching(9));
        model.addAttribute("knowledge_list", knowledgeService.listTopKnowledge(4));
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
