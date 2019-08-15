package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Link;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.ILinkService;
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
 * 友情链接处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class LinkController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private ILinkService linkService;

    /**
     * 友情链接
     * @return
     */
    @RequestMapping("/admin/link")
    public String link(Model model) {
        model.addAttribute("link_list", linkService.listLink());
        return "admin/link";
    }

    /**
     * 图片链接
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/admin/linkEdit")
    public String link(Model model, Long id) {
        model.addAttribute("link", linkService.getById(id));
        return "admin/linkEdit";
    }

    /**
     * 删除友情链接
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/link/delete")
    public AjaxReturn delete(Long id) {
        linkService.deleteLink(id);
        return AjaxReturn.success();
    }

    /**
     * 上传友情链接图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/link/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Link link = new Link();
        link.setAttach(attach);
        linkService.addLink(link);
        return AjaxReturn.success();
    }

    /**
     * 保存链接
     * @param link
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/link/save")
    public AjaxReturn save(Link link) {
        linkService.save(link);
        return AjaxReturn.success();
    }

}
