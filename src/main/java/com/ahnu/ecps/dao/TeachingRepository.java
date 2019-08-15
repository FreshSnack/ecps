package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Teaching;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学活动数据接口
 * @author mxding
 * @date 2019-08-13
 */
public interface TeachingRepository extends JpaRepository<Teaching, Long> {
}
