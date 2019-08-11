package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Apply;

import java.util.List;

/**
 * 申报书服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface IApplyService {

    /**
     * 删除申报书
     * @param id
     */
    void deleteApply(Long id);

    /**
     * 添加申报书
     * @param apply
     */
    void addApply(Apply apply);

    /**
     * 获取申报书列表
     * @return
     */
    List<Apply> listApply();
}
