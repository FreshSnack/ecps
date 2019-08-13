package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Introduce;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 课程简介数据接口
 * @author mxding
 * @date 2019-08-13
 */
public interface IntroduceRepository extends JpaRepository<Introduce, Long> {

}
