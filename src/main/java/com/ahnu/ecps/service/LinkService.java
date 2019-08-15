package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.LinkRepository;
import com.ahnu.ecps.domain.Apply;
import com.ahnu.ecps.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友情链接服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class LinkService implements ILinkService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link getById(Long id) {
        return linkRepository.getOne(id);
    }

    @Override
    public void deleteLink(Long id) {
        Link link = linkRepository.getOne(id);
        linkRepository.deleteById(id);
        attachService.deleteAttach(link.getAttach().getId());
    }

    @Override
    public void addLink(Link link) {
        linkRepository.save(link);
    }

    @Override
    public List<Link> listLink() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return linkRepository.findAll(sort);
    }

    @Override
    public void save(Link link) {
        linkRepository.save(link);
    }
}
