package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Attach;

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
}
