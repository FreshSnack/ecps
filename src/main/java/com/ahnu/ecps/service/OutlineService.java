package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.OutlineRepository;
import com.ahnu.ecps.domain.Outline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
