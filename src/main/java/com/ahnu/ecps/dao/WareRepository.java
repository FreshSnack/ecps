package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Ware;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学课件数据接口
 * @author mxding
 * @date 2019-08-11
 */
public interface WareRepository extends JpaRepository<Ware, Long> {

}
