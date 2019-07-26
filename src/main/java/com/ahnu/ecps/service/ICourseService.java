package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Course;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 课程服务接口
 * @Author: mxding
 * @Date: 2019-07-24 11:02
 */
public interface ICourseService {

    /**
     * 根据id获取课程
     * @param courseId
     * @return
     */
    Course getById(Long courseId);

    /**
     * 获取全部课程
     * @return
     */
    List<Course> listAllCourse();

    /**
     * 获取分页
     * @return
     */
    Page<Course> getPage(int page, int limit);

    /**
     * 保存课程
     * @param course
     */
    void saveCourse(Course course);

    /**
     * 删除课程
     * @param course
     */
    void deleteCourse(Course course);
}
