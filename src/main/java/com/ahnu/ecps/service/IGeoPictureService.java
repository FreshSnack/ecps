package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.GeoPicture;

import java.util.List;

/**
 * 地貌图片服务接口
 * @author mxding
 * @date 2019-08-10
 */
public interface IGeoPictureService {

    /**
     * 删除地貌图片
     * @param id
     */
    void deleteGeoPicture(Long id);

    /**
     * 添加地貌图片
     * @param geoPicture
     */
    void addGeoPicture(GeoPicture geoPicture);

    /**
     * 获取地貌图片列表
     * @return
     */
    List<GeoPicture> listGeoPicture();
}
