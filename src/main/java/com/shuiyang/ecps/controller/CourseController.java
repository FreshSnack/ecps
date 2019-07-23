package com.shuiyang.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 课程控制类
 * @Author: mxding
 * @Date: 2019-07-23 14:41
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    /**
     * 课程编辑页面
     * @return
     */
    @RequestMapping("/courseEdit")
    public String courseEdit() { return "/course/courseEdit"; }

    /**
     * 课程列表页面
     * @return
     */
    @RequestMapping("/courseList")
    public String courseList() { return "/course/courseList"; }




}
