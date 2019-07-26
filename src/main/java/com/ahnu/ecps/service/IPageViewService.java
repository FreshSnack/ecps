package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.PageView;

import java.util.List;

/**
 * 访问量服务接口
 * @Author: mxding
 * @Date: 2019-07-25 08:26
 */
public interface IPageViewService {

    /**
     * 添加访问量
     * @param code
     */
    void addVisitCount(String code);

    /**
     * 获取访问量
     * @param code
     * @return
     */
    Long getVisitCount(String code);

    /**
     * 获取全部的访问量统计
     * @return
     */
    List<PageView> findAllPageView();
}
