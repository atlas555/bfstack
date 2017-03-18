package com.bf.blog.controller.bfstack_bd;

import com.bf.blog.controller.ResponseData;
import com.bf.blog.domain.Post;
import com.bf.blog.enums.PostTypeEnum;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.service.post.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/super/post")
@Slf4j
public class BdPostController {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Log logger = LogFactory.getLog(BdPostController.class);

    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseData<Boolean> addArticle(@RequestParam(value = "author") Long author, @RequestParam(value = "title") String title,
                                   @RequestParam(value = "content") String content, @RequestParam(value = "catalogId") Integer catalogId,
                                   @RequestParam(value = "tag") String tag) throws BfstackServiceException {
        Post post = new Post();
        post.setAuthorId(author);
        post.setTitle(title);
        post.setContent(content);
        post.setCatalogId(catalogId);
        post.setTags(tag);
        post.setStatus(PostTypeEnum.Normal.getType());
        return ResponseData.getOKResult(postService.addPost(post));
    }
}
