package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Introduce;

/**
 * 课程简介服务接口
 * @author mxding
 * @date 2019-08-13
 */
public interface IIntroduceService {

    /**
     * 根据id获取课程简介
     * @return
     */
    Introduce getIntroduce();

    /**
     * 保存课程简介
     * @param content 课程简介内容
     */
    void saveIntroduce(String content);
}
