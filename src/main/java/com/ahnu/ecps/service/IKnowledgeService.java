package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Knowledge;

import java.util.Date;
import java.util.List;

/**
 * 科普园地服务接口
 * @author mxding
 * @date 2019-08-13
 */
public interface IKnowledgeService {

    /**
     * 根据id获取科普园地
     * @param id
     * @return
     */
    Knowledge getById(Long id);

    /**
     * 删除科普园地
     * @param id
     */
    void delete(Long id);

    /**
     * 保存科普园地
     * @param knowledge
     */
    void save(Knowledge knowledge);

    /**
     * 获取所有科普园地
     * @return
     */
    List<Knowledge> listKnowledge();

    List<Knowledge> listTopKnowledge(int top);

    /**
     * 最后发布日期
     * @return
     */
    Date getLastPublishDate();
}
