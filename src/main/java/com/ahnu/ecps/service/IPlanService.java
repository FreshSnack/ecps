package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Plan;

import java.util.List;

/**
 * 教学教案服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface IPlanService {

    /**
     * 删除教案
     * @param id
     */
    void deletePlan(Long id);

    /**
     * 添加教案
     * @param plan
     */
    void addPlan(Plan plan);

    /**
     * 获取教案列表
     * @return
     */
    List<Plan> listPlan();
}
