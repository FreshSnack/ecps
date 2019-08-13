package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Outline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学大纲数据接口
 * @author mxding
 * @date 2019-08-12
 */
public interface OutlineRepository extends JpaRepository<Outline, Long> {
}
