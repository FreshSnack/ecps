package com.ahnu.ecps.dao;

import com.ahnu.ecps.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 访客留言数据接口
 * @Author: mxding
 * @Date: 2019-07-25 08:24
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
