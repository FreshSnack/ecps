package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.TeachingRepository;
import com.ahnu.ecps.domain.Teaching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 教学活动服务
 * @author mxding
 * @date 2019-08-13
 */
@Service
public class TeachingService implements ITeachingService {

    @Autowired
    private TeachingRepository teachingRepository;

    @Override
    public Teaching getTeachingById(Long id) {
        return teachingRepository.getOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        teachingRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Teaching teaching) {
        if(teaching.getPublishTime() == null) {
            teaching.setPublishTime(new Date());
        }
        teachingRepository.save(teaching);
    }

    @Override
    public List<Teaching> listTeaching() {
        Sort sort = new Sort(Sort.Direction.DESC, "publishTime");
        return teachingRepository.findAll(sort);
    }
}
