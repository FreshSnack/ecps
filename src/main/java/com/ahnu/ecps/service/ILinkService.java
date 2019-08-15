package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Link;

import java.util.List;

/**
 * 友情链接服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface ILinkService {

    /**
     * 根据id获取链接
     * @param id
     * @return
     */
    Link getById(Long id);

    /**
     * 删除链接
     * @param id
     */
    void deleteLink(Long id);

    /**
     * 添加友情链接
     * @param link
     */
    void addLink(Link link);

    /**
     * 获取友情链接列表
     * @return
     */
    List<Link> listLink();

    /**
     * 保存友情链接
     * @param link
     */
    void save(Link link);
}
