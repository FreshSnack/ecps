package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Knowledge;
import com.ahnu.ecps.service.IKnowledgeService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 科普园地控制器
 * @author mxding
 * @date 2019-08-13
 */
@Controller
public class KnowledgeController {

    @Autowired
    private IKnowledgeService knowledgeService;

    @RequestMapping("/admin/knowledge")
    public String knowledge(Model model) {
        model.addAttribute("knowledge_list", knowledgeService.listKnowledge());
        return "admin/knowledge";
    }

    /**
     * 科普园地编辑页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/admin/knowledgeEdit")
    public String knowledgeEdit(Model model, Long id) {
        if(id != null) {
            model.addAttribute("knowledge", knowledgeService.getById(id));
        }
        return "admin/knowledgeEdit";
    }

    /**
     * 删除科普园地
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/knowledge/delete")
    public AjaxReturn delete(Long id) {
        knowledgeService.delete(id);
        return AjaxReturn.success();
    }

    /**
     * 保存科普园地
     * @param knowledge
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/knowledge/save")
    public AjaxReturn save(Knowledge knowledge) {
        knowledgeService.save(knowledge);
        return AjaxReturn.success();
    }
}
