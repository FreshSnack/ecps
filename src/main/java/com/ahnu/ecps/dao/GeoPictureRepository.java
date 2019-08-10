package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.GeoPicture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 地貌图片数据接口
 * @author mxding
 * @date 2019-08-10
 */
public interface GeoPictureRepository extends JpaRepository<GeoPicture, Long> {
}
