package com.shuiyang.ecps.service;

import com.shuiyang.ecps.dao.CourseRepository;
import com.shuiyang.ecps.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程服务接口
 * @Author: mxding
 * @Date: 2019-07-23 14:35
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getById(Long courseId) {
        return courseRepository.getOne(courseId);
    }

    @Override
    public List<Course> listAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Page<Course> getPage(int page, int limit) {
        return courseRepository.findAll(PageRequest.of(page, limit));
    }

    @Transactional
    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Transactional
    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }
}
