package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.FeedbackRepository;
import com.ahnu.ecps.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 授课教案服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void deleteFeedback(Long id) {
        Feedback feedback = feedbackRepository.getOne(id);
        feedbackRepository.deleteById(id);
        attachService.deleteAttach(feedback.getAttach().getId());
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> listFeedback() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return feedbackRepository.findAll(sort);
    }
}
