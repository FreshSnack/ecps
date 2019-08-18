package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Outline;

import java.util.Date;
import java.util.List;

/**
 * 教学大纲服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface IOutlineService {

    /**
     * 删除教学大纲
     * @param id
     */
    void deleteOutline(Long id);

    /**
     * 添加教学大纲
     * @param outline
     */
    void addOutline(Outline outline);

    /**
     * 获取教学大纲列表
     * @return
     */
    List<Outline> listOutline();

    Date getLastDate();
}
