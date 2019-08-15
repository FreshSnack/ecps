package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学视频数据接口
 * @author mxding
 * @date 2019-08-14
 */
public interface VideoRepository extends JpaRepository<Video, Long> {
}
