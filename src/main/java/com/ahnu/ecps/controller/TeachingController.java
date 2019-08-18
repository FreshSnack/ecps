package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Teaching;
import com.ahnu.ecps.service.IPageViewService;
import com.ahnu.ecps.service.ITeachingService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 教学活动控制器
 * @author mxding
 * @date 2019-08-13
 */
@Controller
public class TeachingController {

    @Autowired
    private ITeachingService teachingService;

    @Autowired
    private IPageViewService pageViewService;

    @RequestMapping("/teaching")
    public String teaching(Model model, Long id) {
        model.addAttribute("menu_code", "home");
        Teaching teaching = teachingService.getTeachingById(id);
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("teaching_count", pageViewService.getVisitCount("teaching_" + id));
        model.addAttribute("teaching", teaching);
        return "menu/teaching";
    }

    @RequestMapping("/teachingList")
    public String teachingList(Model model) {
        model.addAttribute("menu_code", "home");
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("teaching_count", pageViewService.getVisitCount("teaching"));
        model.addAttribute("teaching_list", teachingService.listTeaching());
        model.addAttribute("lastPublishTime", teachingService.getLastPublishDate());
        return "menu/teachingList";
    }

    @RequestMapping("/admin/teaching")
    public String adminTeaching(Model model) {
        model.addAttribute("teaching_list", teachingService.listTeaching());
        return "admin/teaching";
    }

    /**
     * 教学活动编辑页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/admin/teachingEdit")
    public String teachingEdit(Model model, Long id) {
        if(id != null) {
            model.addAttribute("teaching", teachingService.getTeachingById(id));
        }
        return "admin/teachingEdit";
    }

    /**
     * 删除教学活动
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/teaching/delete")
    public AjaxReturn delete(Long id) {
        teachingService.delete(id);
        return AjaxReturn.success();
    }

    /**
     * 保存教学活动
     * @param teaching
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/teaching/save")
    public AjaxReturn save(Teaching teaching) {
        teachingService.save(teaching);
        return AjaxReturn.success();
    }
}
