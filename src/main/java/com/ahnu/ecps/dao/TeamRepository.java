package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学团队数据接口
 * @author mxding
 * @date 2019-08-12
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
}
