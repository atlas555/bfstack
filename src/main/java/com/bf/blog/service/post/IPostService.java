package com.bf.blog.service.post;


import com.bf.blog.domain.Post;
import com.bf.blog.exceptions.BfstackServiceException;

import java.util.List;

/**
 * @author xiaolong.zhang
 */
public interface IPostService {

    boolean addArticle(Post article) throws BfstackServiceException;

    boolean delArticle(Long id) throws BfstackServiceException;

    boolean updateArticle(Post article) throws BfstackServiceException;

    List<Post> getArticles() throws BfstackServiceException;

    Post getArticleById(Long id) throws BfstackServiceException;

}
