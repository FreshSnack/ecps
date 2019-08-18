package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Ware;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IPageViewService;
import com.ahnu.ecps.service.IWareService;
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
 * 教学课件处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class WareController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IWareService wareService;

    @Autowired
    private IPageViewService pageViewService;

    /**
     * 教学课件
     */
    @RequestMapping("/ware")
    public String ware(Model model) {
        model.addAttribute("lastDate", wareService.getLastDate());
        model.addAttribute("pv_count", pageViewService.getVisitCount("home"));
        model.addAttribute("menu_code", "ware");
        model.addAttribute("ware_count", pageViewService.getVisitCount("ware"));
        model.addAttribute("doc_list", wareService.listWare());
        return "menu/ware";
    }

    /**
     * 教学课件
     * @return
     */
    @RequestMapping("/admin/ware")
    public String adminWare(Model model) {
        model.addAttribute("doc_list", wareService.listWare());
        return "admin/ware";
    }

    /**
     * 删除教学课件
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/ware/delete")
    public AjaxReturn delete(Long id) {
        wareService.deleteWare(id);
        return AjaxReturn.success();
    }

    /**
     * 上传教学课件附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/ware/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Ware ware = new Ware();
        ware.setAttach(attach);
        ware.setCreateTime(new Date());
        wareService.addWare(ware);
        return AjaxReturn.success();
    }
}
