package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Feedback;

import java.util.List;

/**
 * 教学反馈服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface IFeedbackService {

    /**
     * 删除教学反馈
     * @param id
     */
    void deleteFeedback(Long id);

    /**
     * 添加教学反馈
     * @param feedback
     */
    void addFeedback(Feedback feedback);

    /**
     * 获取教学反馈列表
     * @return
     */
    List<Feedback> listFeedback();
}
