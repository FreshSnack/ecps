package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Outline;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IOutlineService;
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
 * 教学大纲处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class OutlineController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IOutlineService outlineService;

    @Autowired
    private IPageViewService pageViewService;
    /**
     * 教学大纲
     */
    @RequestMapping("/outline")
    public String outline(Model model) {
        model.addAttribute("lastDate", outlineService.getLastDate());
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("menu_code", "outline");
        model.addAttribute("outline_count", pageViewService.getVisitCount("outline"));
        model.addAttribute("outline_list", outlineService.listOutline());
        return "menu/outline";
    }

    /**
     * 教学大纲
     * @return
     */
    @RequestMapping("/admin/outline")
    public String adminOutline(Model model) {
        model.addAttribute("doc_list", outlineService.listOutline());
        return "admin/outline";
    }

    /**
     * 删除教学大纲
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/outline/delete")
    public AjaxReturn delete(Long id) {
        outlineService.deleteOutline(id);
        return AjaxReturn.success();
    }

    /**
     * 上传教学大纲附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/outline/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Outline outline = new Outline();
        outline.setAttach(attach);
        outline.setCreateTime(new Date());
        outlineService.addOutline(outline);
        return AjaxReturn.success();
    }
}
