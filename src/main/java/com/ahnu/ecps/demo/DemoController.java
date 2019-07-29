package com.ahnu.ecps.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 案例控制器
 * @Author: mxding
 * @Date: 2019-07-29 14:41
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/iconfont")
    public String iconfont() { return "demo/iconfont"; }
}
