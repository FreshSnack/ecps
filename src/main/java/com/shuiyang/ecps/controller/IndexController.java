package com.shuiyang.ecps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index控制类
 * @Author: mxding
 * @Date: 2019-07-23 14:05
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() { return "index"; }
}
