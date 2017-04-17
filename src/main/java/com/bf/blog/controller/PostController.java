package com.bf.blog.controller;

import com.bf.blog.enums.ErrorCodeEnum;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.service.post.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title:
 * @Desc:
 * @Author zhangxiaolong
 * @Date 2015-10-27 14:05.
 */
@Controller
@RequestMapping("/post")
@Slf4j
public class PostController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private IPostService postService;

    @ApiOperation(value = "文章详情页", notes = "")
    @RequestMapping(path = "/{postId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String detail(ModelMap map, @PathVariable(value = "postId") Long postId) {
        try {
            map.addAttribute("post", postService.getPostById(postId));
        } catch (BfstackServiceException e) {
            log.error(ErrorCodeEnum.GET_ARTICLE_FAILED.getErrorMsg(), e);
        }

        return "post";
    }
}
