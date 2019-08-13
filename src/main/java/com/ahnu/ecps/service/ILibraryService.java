package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Library;

import java.util.List;

/**
 * 试题库服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface ILibraryService {

    /**
     * 删除试题库
     * @param id
     */
    void deleteLibrary(Long id);

    /**
     * 添加试题库
     * @param library
     */
    void addLibrary(Library library);

    /**
     * 获取试题库列表
     * @return
     */
    List<Library> listLibrary();
}
