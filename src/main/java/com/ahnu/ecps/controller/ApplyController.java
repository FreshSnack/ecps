package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Apply;
import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.service.IApplyService;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 申报书处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
@RequestMapping("/admin/apply")
public class ApplyController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IApplyService applyService;

    /**
     * 申报书
     * @return
     */
    @RequestMapping
    public String apply(Model model) {
        model.addAttribute("doc_list", applyService.listApply());
        return "admin/apply";
    }

    /**
     * 删除申报书
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn delete(Long id) {
        applyService.deleteApply(id);
        return AjaxReturn.success();
    }

    /**
     * 上传申报书附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Apply apply = new Apply();
        apply.setAttach(attach);
        applyService.addApply(apply);
        return AjaxReturn.success();
    }
}
