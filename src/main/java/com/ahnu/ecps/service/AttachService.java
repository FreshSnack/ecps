package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.AttachRepository;
import com.ahnu.ecps.domain.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dingmx
 * @date 2019/7/27 23:51
 */
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
        if(!exist) {
            throw new RuntimeException("附件不存在");
        } else {
            return attachRepository.findById(id).get();
        }
    }
}
