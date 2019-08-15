package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 科普园地数据接口
 * @author mxding
 * @date 2019-08-13
 */
public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {
}
