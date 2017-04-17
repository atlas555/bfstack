package com.bf.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxiaolong
 * @date 2017/4/17 下午4:18
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

}
