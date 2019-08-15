package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Teaching;

import java.util.List;

/**
 * 教学活动服务接口
 * @author mxding
 * @date 2019-08-13
 */
public interface ITeachingService {

    /**
     * 根据id获取教学活动
     * @param id
     * @return
     */
    Teaching getTeachingById(Long id);

    /**
     * 删除教学活动
     * @param id
     */
    void delete(Long id);

    /**
     * 保存教学活动
     * @param teaching
     */
    void save(Teaching teaching);

    /**
     * 获取所有教学活动
     * @return
     */
    List<Teaching> listTeaching();
}
