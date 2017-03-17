package com.bf.blog.controller;

import com.bf.blog.domain.Post;
import com.bf.blog.enums.ErrorCodeEnum;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.service.post.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title:
 * @Desc:
 * @Author zhangxiaolong
 * @Date 2015-10-27 14:05.
 */
@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private IPostService postService;

    @RequestMapping(path = "/{postId}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView detail(@PathVariable(value = "postId") Long postId) {
        ModelAndView model = new ModelAndView();
        try {
            Post post = postService.getArticleById(postId);
            model.addObject("post", post);
        } catch (BfstackServiceException e) {
            log.error(ErrorCodeEnum.GET_ARTICLE_FAILED.getErrorMsg(), e);
        }

        model.setViewName("post");
        return model;
    }
}
