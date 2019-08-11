package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.GeoPictureRepository;
import com.ahnu.ecps.domain.GeoPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 地貌图片服务
 * @author mxding
 * @date 2019-08-10
 */
@Service
public class GeoPictureService implements IGeoPictureService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private GeoPictureRepository geoPictureRepository;

    @Override
    @Transactional
    public void deleteGeoPicture(Long id) {
        GeoPicture geoPicture = geoPictureRepository.getOne(id);
        geoPictureRepository.deleteById(id);
        attachService.deleteAttach(geoPicture.getAttach().getId());
    }

    @Override
    @Transactional
    public void addGeoPicture(GeoPicture geoPicture) {
        geoPictureRepository.save(geoPicture);
    }

    @Override
    public List<GeoPicture> listGeoPicture() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return geoPictureRepository.findAll(sort);
    }
}
