package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.AttachRepository;
import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.utils.AjaxReturn;
import com.ahnu.ecps.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author dingmx
 * @date 2019/7/27 23:51
 */
@Slf4j
@Service
public class AttachService implements IAttachService {

    @Autowired
    private AttachRepository attachRepository;

    @Override
    @Transactional
    public void saveAttach(Attach attach) {
        attachRepository.save(attach);
    }


    @Override
    public Attach getAttachById(Long id) {
        boolean exist = attachRepository.existsById(id);
        if (!exist) {
            throw new RuntimeException("附件不存在");
        } else {
            return attachRepository.findById(id).get();
        }
    }

    @Override
    @Transactional
    public Attach uploadFile(MultipartFile file) {
        Attach attach;
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //重新生成文件名
        String newFileName = StringUtils.getUUID() + "_" + originalFilename;
        //指定服务器存储路径
        String localFilePath = StringUtils.getAttachRootPath() + newFileName;
        try {
            //将文件保存到服务器
            file.transferTo(new File(localFilePath));
            //创建附件对象
            attach = new Attach();
            attach.setFileName(originalFilename);
            attach.setPath(StringUtils.getAttachRelativeRootPath() + newFileName);
            attach.setSuffix(suffix);
            attachRepository.save(attach);
        } catch (IOException e) {
            throw new RuntimeException("上传文件异常" + e.getMessage());
        }
        return attach;
    }

    @Override
    public void deleteAttach(Long id) {
        Optional<Attach> optional = attachRepository.findById(id);
        if(!optional.isPresent()) {
            throw new RuntimeException("附件不存在[id=" + id + "]");
        } else {
            Attach attach = optional.get();
            attachRepository.delete(attach);
            File file = new File(StringUtils.getProjectRootPath() + attach.getPath());
            if(!file.exists()) {
                log.warn("文件{}不存在", attach.getPath());
            } else {
                try {
                    FileUtils.forceDelete(file);
                } catch (IOException e) {
                    log.error("强制删除文件异常：{}" , e.getMessage());
                }
            }
        }
    }

}
