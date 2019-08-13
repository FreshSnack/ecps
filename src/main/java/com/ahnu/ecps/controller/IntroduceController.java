package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Introduce;
import com.ahnu.ecps.service.IIntroduceService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 课程简介控制器
 * @author mxding
 * @date 2019-08-13
 */
@Controller
public class IntroduceController {

    @Autowired
    private IIntroduceService introduceService;

    /**
     * 课程简介
     * @param model
     * @return
     */
    @RequestMapping("/admin/introduce")
    public String introduce(Model model) {
        Introduce introduce = introduceService.getIntroduce();
        model.addAttribute("introduce", introduce);
        return "admin/introduce";
    }

    /**
     * 保存课程简介
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/introduce/save")
    public AjaxReturn save(String content) {
        introduceService.saveIntroduce(content);
        return AjaxReturn.success();
    }
}
