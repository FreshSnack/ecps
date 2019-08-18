package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Plan;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IPageViewService;
import com.ahnu.ecps.service.IPlanService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 授课教案处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class PlanController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IPlanService planService;

    @Autowired
    private IPageViewService pageViewService;

    /**
     * 授课教案
     * @return
     */
    @RequestMapping("/admin/plan")
    public String adminPlan(Model model) {
        model.addAttribute("doc_list", planService.listPlan());
        return "admin/plan";
    }

    /**
     * 授课教案
     */
    @RequestMapping("/plan")
    public String plan(Model model) {
        model.addAttribute("lastDate", planService.getLastDate());
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("menu_code", "plan");
        model.addAttribute("plan_count", pageViewService.getVisitCount("plan"));
        model.addAttribute("plan_list", planService.listPlan());
        return "menu/plan";
    }



    /**
     * 删除授课教案
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/plan/delete")
    public AjaxReturn delete(Long id) {
        planService.deletePlan(id);
        return AjaxReturn.success();
    }

    /**
     * 上传教学课件附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/plan/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Plan plan = new Plan();
        plan.setAttach(attach);
        plan.setCreateTime(new Date());
        planService.addPlan(plan);
        return AjaxReturn.success();
    }
}
