package com.bf.blog.service.user;


import com.bf.blog.domain.User;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.requestParam.MailLoginDO;

/**
 * @author xiaolong.zhang
 */
public interface IUserService {

    /**
     * 获取用户信息
     * 
     * @param id
     * @return
     */
    public User getUserById(long id);

    /**
     *
     * @param id
     * @return
     */
    public User getUserBriefById(long id);

    /**
     * 插入用户信息
     * 
     * @param user
     * @return
     */
    public int insertUser(User user);

    String loginByMail(MailLoginDO mailDO) throws BfstackServiceException;

    boolean logout(User currentUser);
}
