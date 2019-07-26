package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Course;
import com.ahnu.ecps.service.ICourseService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 课程控制类
 * @Author: mxding
 * @Date: 2019-07-23 14:41
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

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

    /**
     * 获取所有课程
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCourseList")
    public AjaxReturn getCourseList() {
        List<Course> courseList = courseService.listAllCourse();
        return AjaxReturn.success(courseList, Long.parseLong(courseList.size() + ""));
    }

    /**
     * 获取分页
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPage")
    public AjaxReturn getPage(int page, int limit) {
        Page<Course> coursePage = courseService.getPage(page - 1, limit);
        return AjaxReturn.success(coursePage.getContent(), coursePage.getTotalElements());
    }
}
