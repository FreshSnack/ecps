package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.utils.AjaxReturn;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * 附件控制器
 *
 * @author dingmx
 * @date 2019/7/27 23:44
 */
@RestController
public class AttachController {

    @Autowired
    private IAttachService attachService;

    @RequestMapping("/download")
    public AjaxReturn download(HttpServletResponse response, Long id) {
        Attach attach = attachService.getAttachById(id);
        if (attach == null) {
            throw new RuntimeException("附件不存在");
        }
        // 目前是相对路径
        String path = attach.getPath();
        InputStream inputStream = AttachController.class.getResourceAsStream(path);
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
            throw new RuntimeException("读取文件异常", e);
        }
        return AjaxReturn.success("download success");
    }
}
