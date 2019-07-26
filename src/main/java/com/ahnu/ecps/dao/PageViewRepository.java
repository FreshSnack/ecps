package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.PageView;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 访问量数据接口
 * @Author: mxding
 * @Date: 2019-07-25 08:24
 */
public interface PageViewRepository extends JpaRepository<PageView, Long> {

    /**
     * 根据code获取访问量实体
     * @param code
     * @return
     */
    PageView findByCode(String code);
}
