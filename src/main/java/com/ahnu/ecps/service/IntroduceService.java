package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.IntroduceRepository;
import com.ahnu.ecps.domain.Introduce;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程简介服务
 * @author mxding
 * @date 2019-08-13
 */
@Service
public class IntroduceService implements IIntroduceService {

    @Autowired
    private IntroduceRepository introduceRepository;

    @Override
    public Introduce getIntroduce() {
        Introduce introduce;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Introduce> introduceList = introduceRepository.findAll(sort);
        if(SetUtils.isNullList(introduceList)) {
            introduce = new Introduce();
            introduce.setContent("");
            introduceRepository.save(introduce);
        } else {
            introduce = introduceList.get(0);
        }
        return introduce;
    }

    @Override
    @Transactional
    public void saveIntroduce(String content) {
        Introduce introduce = getIntroduce();
        introduce.setContent(content);
        introduceRepository.save(introduce);
    }
}
