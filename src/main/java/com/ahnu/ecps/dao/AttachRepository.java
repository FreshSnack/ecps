package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Attach;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 附件数据接口
 */
public interface AttachRepository extends JpaRepository<Attach, Long> {
}
