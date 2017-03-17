package com.bf.blog.service.post.impl;

import com.bf.blog.domain.Post;
import com.bf.blog.domain.User;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.mapper.PostMapper;
import com.bf.blog.service.post.IPostService;
import com.bf.blog.service.user.IUserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaolong
 * @date 16/2/3 下午8:09
 */
@Service
public class PostServiceImpl implements IPostService {

    private static final Log logger = LogFactory.getLog(PostServiceImpl.class);

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private IUserService userService;

    @Override
    public boolean addArticle(Post article) throws BfstackServiceException {
        int col = postMapper.insert(article);
        return 1 == col;
    }

    @Override
    public boolean delArticle(Long id) throws BfstackServiceException {
        int col = postMapper.delArticle(id);
        return 1 == col;
    }

    @Override
    public boolean updateArticle(Post article) throws BfstackServiceException {
        int col = postMapper.updateArticle(article);
        return 1 == col;
    }

    @Override
    public List<Post> getArticles() throws BfstackServiceException {
        List<Post> articles = postMapper.getArticles();
        if (CollectionUtils.isEmpty(articles)) {
            return new ArrayList<>();
        }
        // todo 拼装article
        for (Post a : articles) {
            a.setComments(5);
            a.setViews(1224);
        }

        return articles;
    }

    @Override
    public Post getArticleById(Long id) throws BfstackServiceException {
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
