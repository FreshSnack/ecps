package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Video;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.IVideoService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教学视频处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class VideoController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IVideoService videoService;

    /**
     * 教学视频
     * @return
     */
    @RequestMapping("/admin/video")
    public String video(Model model) {
        model.addAttribute("video_list", videoService.listVideo());
        return "admin/video";
    }

    /**
     * 教学视频编辑
     * @return
     */
    @RequestMapping("/admin/videoEdit")
    public String videoEdit(Model model, Long id) {
        model.addAttribute("video", videoService.getById(id));
        return "admin/videoEdit";
    }

    /**
     * 删除教学视频
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/video/delete")
    public AjaxReturn delete(String ids) {
        videoService.deleteVideo(ids);
        return AjaxReturn.success();
    }

    /**
     * 上传教学视频附件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/video/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Video video = new Video();
        video.setAttach(attach);
        videoService.addVideo(video);
        return AjaxReturn.success();
    }

    /**
     * 保存教学视频
     * @param video
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/video/save")
    public AjaxReturn save(Video video) {
        videoService.save(video);
        return AjaxReturn.success();
    }
}
