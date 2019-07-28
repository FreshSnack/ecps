package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.PageViewRepository;
import com.ahnu.ecps.domain.PageView;
import com.ahnu.ecps.exception.BusinessException;
import com.ahnu.ecps.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 访问量服务类
 * @Author: mxding
 * @Date: 2019-07-25 08:28
 */
@Service
public class PageViewService implements IPageViewService {

    @Autowired
    private PageViewRepository pageViewRepository;

    @Override
    @Transactional
    public void addVisitCount(String code) {
        if(StringUtils.isNullString(code)) {
            throw new BusinessException("访问量统计代码为空");
        }
        PageView pageView = pageViewRepository.findByCode(code);
        if(pageView == null) {
            pageView = new PageView(code);
        }
        pageView.setVisitCount(pageView.getVisitCount() + 1);
        pageViewRepository.save(pageView);
    }

    @Override
    public Long getVisitCount(String code) {
        if(StringUtils.isNullString(code)) {
            throw new BusinessException("访问量统计代码为空");
        }
        PageView pageView = pageViewRepository.findByCode(code);
        if(pageView == null) {
            return 0L;
        }
        return pageView.getVisitCount();
    }

    @Override
    public List<PageView> findAllPageView() {
        return pageViewRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
    }

}
