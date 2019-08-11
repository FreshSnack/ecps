package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Attach;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件服务接口
 * @author dingmx
 * @date 2019/7/27 23:51
 */
public interface IAttachService {

    /**
     * 保存附件
     * @param attach
     */
    void saveAttach(Attach attach);

    /**
     * 获取附件
     */
    Attach getAttachById(Long id);

    /**
     * 上传文件
     * @param file
     */
    Attach uploadFile(MultipartFile file);

    /**
     * 删除附件
     * @param id
     */
    void deleteAttach(Long id);
}
