package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 试题库数据接口
 * @author mxding
 * @date 2019-08-12
 */
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
