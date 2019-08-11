package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 申报书数据接口
 * @author mxding
 * @date 2019-08-11
 */
public interface ApplyRepository extends JpaRepository<Apply, Long> {
}
