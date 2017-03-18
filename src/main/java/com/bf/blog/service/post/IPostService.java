package com.bf.blog.service.post;


import com.bf.blog.domain.Post;
import com.bf.blog.exceptions.BfstackServiceException;

/**
 * @author xiaolong.zhang
 */
public interface IPostService {

    boolean addPost(Post post) throws BfstackServiceException;

    Post getPostById(Long id) throws BfstackServiceException;

}
