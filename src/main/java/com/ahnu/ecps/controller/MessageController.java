package com.ahnu.ecps.controller;

import com.ahnu.ecps.service.IMessageService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 留言控制器
 * @author dingmx
 * @date 2019/7/28 13:37
 */
@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    /**
     * 访客留言
     * @return
     */
    @RequestMapping("/message")
    public String message() {
        return "index/message";
    }

    /**
     * 添加留言
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/addMessage")
    public AjaxReturn addMessage(String message) {
        messageService.addMessage(message);
        return AjaxReturn.success("success");
    }

    /**
     * 删除留言
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/deleteMessage")
    public AjaxReturn deleteMessage(Long id) {
        messageService.deleteMessage(id);
        return AjaxReturn.success("success");
    }

}
