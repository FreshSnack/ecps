package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.ApplyRepository;
import com.ahnu.ecps.domain.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 申报书服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class ApplyService implements IApplyService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private ApplyRepository applyRepository;

    @Override
    public void deleteApply(Long id) {
        Apply apply = applyRepository.getOne(id);
        applyRepository.deleteById(id);
        attachService.deleteAttach(apply.getAttach().getId());
    }

    @Override
    public void addApply(Apply apply) {
        applyRepository.save(apply);
    }

    @Override
    public List<Apply> listApply() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return applyRepository.findAll(sort);
    }
}
