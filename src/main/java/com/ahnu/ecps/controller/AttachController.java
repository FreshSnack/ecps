package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.exception.BusinessException;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.utils.AjaxReturn;
import com.ahnu.ecps.utils.StringUtils;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 附件控制器
 *
 * @author dingmx
 * @date 2019/7/27 23:44
 */
@Slf4j
@RestController
public class AttachController {

    @Autowired
    private IAttachService attachService;

    @RequestMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void download(HttpServletResponse response, Long id) {
        Attach attach = attachService.getAttachById(id);
        if (attach == null) {
            throw new RuntimeException("附件不存在[id=" + id + "]");
        }
        // 目前是相对路径
        String path = attach.getPath();
        File file = new File(StringUtils.getFilePath(StringUtils.getProjectRootPath() + path));
        if(file == null || !file.exists()) {
            throw new RuntimeException("附件不存在[path=" + path + "]");
        }
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("附件文件不存在");
        }
        //设置Headers
        response.setHeader("Content-Type", "application/octet-stream");
        //设置下载的文件的名称
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(attach.getFileName().getBytes("gb2312"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("文件名转码错误");
        }
        try {
            @Cleanup
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            log.error("读取文件异常[" + e.getMessage() + "]");
        }
        // 保存下载次数
        Long downs = attach.getDowns() == null ? 0L : attach.getDowns();
        attach.setDowns(downs + 1);
        attachService.saveAttach(attach);
    }

    /**
     * 通用上传图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public AjaxReturn upload(HttpServletRequest request) {
        StandardMultipartHttpServletRequest multipartRequest = (StandardMultipartHttpServletRequest) request;
        List<MultipartFile> multipartFiles = multipartRequest.getFiles("fileToUpload");
        if(multipartFiles == null || multipartFiles.size() == 0) {
            throw new BusinessException("上传文件为空");
        }
        MultipartFile firstFile = multipartFiles.get(0);
        Attach attach = attachService.uploadFile(firstFile);
        return AjaxReturn.success(attach.getId());
    }
}
