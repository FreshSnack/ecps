package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教学反馈
 * @author mxding
 * @date 2019-08-12
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
