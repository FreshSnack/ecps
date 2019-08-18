package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Feedback;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IFeedbackService;
import com.ahnu.ecps.service.IPageViewService;
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
 * 教学反馈处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class FeedbackController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private IPageViewService pageViewService;

    /**
     * 教学反馈
     */
    @RequestMapping("/feedback")
    public String feedback(Model model) {
        model.addAttribute("lastDate", feedbackService.getLastDate());
        model.addAttribute("menu_code", "feedback");
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("feedback_count", pageViewService.getVisitCount("feedback"));
        model.addAttribute("doc_list", feedbackService.listFeedback());
        return "menu/feedback";
    }

    /**
     * 授课教案
     * @return
     */
    @RequestMapping("/admin/feedback")
    public String adminFeedback(Model model) {
        model.addAttribute("doc_list", feedbackService.listFeedback());
        return "admin/feedback";
    }

    /**
     * 删除授课教案
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/feedback/delete")
    public AjaxReturn delete(Long id) {
        feedbackService.deleteFeedback(id);
        return AjaxReturn.success();
    }

    /**
     * 上传教学课件附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/feedback/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Feedback feedback = new Feedback();
        feedback.setAttach(attach);
        feedback.setCreateTime(new Date());
        feedbackService.addFeedback(feedback);
        return AjaxReturn.success();
    }
}
