package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.ApplyRepository;
import com.ahnu.ecps.domain.Apply;
import com.ahnu.ecps.domain.Knowledge;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Apply> page = applyRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Apply> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }

}
