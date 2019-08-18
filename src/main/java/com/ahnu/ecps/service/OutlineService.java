package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.OutlineRepository;
import com.ahnu.ecps.domain.Outline;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 教学大纲服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class OutlineService implements IOutlineService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private OutlineRepository outlineRepository;

    @Override
    public void deleteOutline(Long id) {
        Outline outline = outlineRepository.getOne(id);
        outlineRepository.deleteById(id);
        attachService.deleteAttach(outline.getAttach().getId());
    }

    @Override
    public void addOutline(Outline outline) {
        outlineRepository.save(outline);
    }

    @Override
    public List<Outline> listOutline() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return outlineRepository.findAll(sort);
    }

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Outline> page = outlineRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Outline> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }
}
