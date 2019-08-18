package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.WareRepository;
import com.ahnu.ecps.domain.Ware;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Ware> page = wareRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Ware> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }
}
