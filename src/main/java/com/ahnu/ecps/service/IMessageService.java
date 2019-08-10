package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Message;

import java.util.List;

/**
 * 访客留言服务接口
 * @author dingmx
 * @date 2019/7/27 23:51
 */
public interface IMessageService {

    /**
     * 新增消息
     * @param content 消息内容
     */
    void addMessage(String content);

    /**
     * 获取消息列表
     * @return
     */
    List<Message> getMessageList();

    /**
     * 删除消息
     * @param id
     */
    void deleteMessage(Long id);

    /**
     * 获取前几个消息
     * @param top
     * @return
     */
    List<Message> getTopMessageList(int top);
}
