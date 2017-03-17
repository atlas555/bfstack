package com.bf.blog.service.user.impl;


import com.bf.blog.domain.User;
import com.bf.blog.mapper.UserMapper;
import com.bf.blog.requestParam.MailLoginDO;
import com.bf.blog.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong.zhang
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserBriefById(long id) {
        return userMapper.getUserBriefById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public String loginByMail(MailLoginDO mailDO) {
        return null;
    }

    @Override
    public boolean logout(User currentUser) {
        userMapper.updateToken(currentUser.getId(), "");
        return true;
    }
}
