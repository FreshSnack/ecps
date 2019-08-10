package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.MessageRepository;
import com.ahnu.ecps.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 访客留言服务类
 * @author dingmx
 * @date 2019/7/28 14:00
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public void addMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        message.setCreateTime(new Date());
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessageList() {
        return messageRepository.findAll(new Sort(Sort.Direction.DESC, "createTime"));
    }

    @Override
    @Transactional
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> getTopMessageList(int top) {
        // 按创建时间倒序
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Message> page = messageRepository.findAll(PageRequest.of(0 , top, sort));
        return page.getContent();
    }
}
