package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.GeoPicture;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IGeoPictureService;
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
 * 地貌图片处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
@RequestMapping("/admin/picture")
public class GeoPictureController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IGeoPictureService geoPictureService;

    /**
     * 地貌图片
     * @return
     */
    @RequestMapping
    public String picture(Model model) {
        model.addAttribute("pic_list", geoPictureService.listGeoPicture());
        return "admin/picture";
    }

    /**
     * 删除地貌图片
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn delete(Long id) {
        geoPictureService.deleteGeoPicture(id);
        return AjaxReturn.success();
    }

    /**
     * 上传地貌图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        GeoPicture geoPicture = new GeoPicture();
        geoPicture.setAttach(attach);
        geoPictureService.addGeoPicture(geoPicture);
        return AjaxReturn.success();
    }
}
