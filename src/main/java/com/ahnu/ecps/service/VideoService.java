package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.VideoRepository;
import com.ahnu.ecps.domain.Video;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 教学视频服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class VideoService implements IVideoService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video getById(Long id) {
        return videoRepository.getOne(id);
    }

    @Override
    @Transactional
    public void deleteVideo(String ids) {
        String[] idArr = ids.split(",");
        for(String id: idArr) {
            Video video = videoRepository.getOne(Long.valueOf(id));
            videoRepository.delete(video);
            attachService.deleteAttach(video.getAttach().getId());
        }
    }

    @Override
    @Transactional
    public void addVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public List<Video> listVideo() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return videoRepository.findAll(sort);
    }

    @Override
    @Transactional
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Video> page = videoRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Video> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }
}
