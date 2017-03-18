package com.bf.blog.service.post.impl;

import com.bf.blog.domain.Post;
import com.bf.blog.domain.User;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.mapper.PostMapper;
import com.bf.blog.service.post.IPostService;
import com.bf.blog.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxiaolong
 * @date 16/2/3 下午8:09
 */
@Service
@Slf4j
public class PostServiceImpl implements IPostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private IUserService userService;

    @Override
    public boolean addPost(Post article) throws BfstackServiceException {
        int col = postMapper.insert(article);
        return 1 == col;
    }

    @Override
    public Post getPostById(Long id) throws BfstackServiceException {
        Post article = postMapper.getArticleById(id);
        if (null != article) {
            User user = userService.getUserBriefById(article.getAuthorId());
            if (null != user) {
                article.setAuthor(user);
            }
        }
        return article;
    }

}
