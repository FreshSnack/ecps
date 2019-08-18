package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.LibraryRepository;
import com.ahnu.ecps.domain.Library;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 试题库服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public void deleteLibrary(Long id) {
        Library library = libraryRepository.getOne(id);
        libraryRepository.deleteById(id);
        attachService.deleteAttach(library.getAttach().getId());
    }

    @Override
    public void addLibrary(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public List<Library> listLibrary() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return libraryRepository.findAll(sort);
    }

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Library> page = libraryRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Library> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }
}
