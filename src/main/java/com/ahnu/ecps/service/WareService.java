package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.WareRepository;
import com.ahnu.ecps.domain.Ware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教学课件服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class WareService implements IWareService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private WareRepository wareRepository;

    @Override
    public void deleteWare(Long id) {
        Ware ware = wareRepository.getOne(id);
        wareRepository.deleteById(id);
        attachService.deleteAttach(ware.getAttach().getId());
    }

    @Override
    public void addWare(Ware ware) {
        wareRepository.save(ware);
    }

    @Override
    public List<Ware> listWare() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return wareRepository.findAll(sort);
    }
}
