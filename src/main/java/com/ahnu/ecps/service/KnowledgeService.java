package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.KnowledgeRepository;
import com.ahnu.ecps.domain.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 科普园地服务
 * @author mxding
 * @date 2019-08-13
 */
@Service
public class KnowledgeService implements IKnowledgeService {

    @Autowired
    private KnowledgeRepository knowledgeRepository;

    @Override
    public Knowledge getById(Long id) {
        return knowledgeRepository.getOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        knowledgeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Knowledge knowledge) {
        if(knowledge.getPublishTime() == null) {
            knowledge.setPublishTime(new Date());
        }
        knowledgeRepository.save(knowledge);
    }

    @Override
    public List<Knowledge> listKnowledge() {
        Sort sort = new Sort(Sort.Direction.DESC, "publishTime");
        return knowledgeRepository.findAll(sort);
    }
}
