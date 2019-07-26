package com.ahnu.ecps.controller;

import com.ahnu.ecps.service.IPageViewService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 访问量控制类
 * @Author: mxding
 * @Date: 2019-07-25 08:38
 */
@Controller
public class PageViewController {

    @Autowired
    private IPageViewService pageViewService;

    /**
     * 添加访问量
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/addVisitCount")
    public AjaxReturn addVisitCount(String code) {
        pageViewService.addVisitCount(code);
        return AjaxReturn.success(pageViewService.getVisitCount(code));
    }

    /**
     * 获取访问量
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVisitCount")
    public AjaxReturn getVisitCount(String code) {
        return AjaxReturn.success(pageViewService.getVisitCount(code));
    }

    /**
     * 获取全部的访问量统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/getAllPageView")
    public AjaxReturn getAllPageView() {
        return AjaxReturn.success(pageViewService.findAllPageView());
    }
}
