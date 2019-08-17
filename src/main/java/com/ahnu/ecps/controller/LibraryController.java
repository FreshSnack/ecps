package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Library;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.ILibraryService;
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

/**
 * 试题库处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class LibraryController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private ILibraryService libraryService;

    @Autowired
    private IPageViewService pageViewService;

    /**
     * 试题库
     */
    @RequestMapping("/library")
    public String library(Model model) {
        model.addAttribute("menu_code", "library");
        model.addAttribute("library_count", pageViewService.getVisitCount("library"));
        model.addAttribute("doc_list", libraryService.listLibrary());
        return "menu/library";
    }

    /**
     * 试题库
     * @return
     */
    @RequestMapping("/admin/library")
    public String adminLibrary(Model model) {
        model.addAttribute("doc_list", libraryService.listLibrary());
        return "admin/library";
    }

    /**
     * 删除试题库
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/library/delete")
    public AjaxReturn delete(Long id) {
        libraryService.deleteLibrary(id);
        return AjaxReturn.success();
    }

    /**
     * 上传教学课件附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/library/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Library library = new Library();
        library.setAttach(attach);
        libraryService.addLibrary(library);
        return AjaxReturn.success();
    }
}
