package com.bf.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title:
 * @Desc:
 * @Author zhangxiaolong
 * @Date 2015-10-27 14:05.
 */
@Controller
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    private static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseData addArticle(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
                             @RequestParam(value = "content") String content) {

        return ResponseData.getOKResult(null);
    }
}
