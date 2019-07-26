package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 课程数据接口
 * @Author: mxding
 * @Date: 2019-07-23 14:34
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
