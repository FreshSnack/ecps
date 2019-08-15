package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 友情链接数据接口
 * @author mxding
 * @date 2019-08-14
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
}
