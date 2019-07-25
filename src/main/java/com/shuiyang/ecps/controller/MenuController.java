package com.shuiyang.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单视图映射器
 * @Author: mxding
 * @Date: 2019-07-25 12:41
 */
@Controller
public class MenuController {

    @RequestMapping("/menu/{view}")
    public String menu(@PathVariable String view) {
        return "menu/" + view;
    }
}
