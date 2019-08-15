package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Video;

import java.util.List;

/**
 * 教学视频服务接口
 * @author mxding
 * @date 2019-08-14
 */
public interface IVideoService {

    /**
     * 根据id获取视频
     * @param id
     * @return
     */
    Video getById(Long id);

    /**
     * 删除教学视频
     * @param ids
     */
    void deleteVideo(String ids);

    /**
     * 添加教学视频
     * @param video
     */
    void addVideo(Video video);

    /**
     * 获取教学视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 保存视频
     * @param video
     */
    void save(Video video);
}
