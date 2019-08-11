package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Ware;

import java.util.List;

/**
 * 教学课件服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface IWareService {

    /**
     * 删除教学课件
     * @param id
     */
    void deleteWare(Long id);

    /**
     * 添加教学课件
     * @param ware
     */
    void addWare(Ware ware);

    /**
     * 获取教学课件列表
     * @return
     */
    List<Ware> listWare();
}
