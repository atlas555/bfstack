package com.bf.blog.controller.bfstack_bd;

import com.bf.blog.annotations.LoginRequied;
import com.bf.blog.controller.ResponseData;
import com.bf.blog.exceptions.BfstackServiceException;
import com.bf.blog.interceptor.ThreadLocalContext;
import com.bf.blog.requestParam.MailLoginDO;
import com.bf.blog.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhubin on 2017/1/14.
 */
@RestController
@RequestMapping(path="/super")
public class BdLoginController {

    private static final Logger logger = LoggerFactory.getLogger(BdLoginController.class);

    @Autowired
    private IUserService userService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path="login/mail", produces = "application/json")
    public ResponseData<String> loginByMail(@RequestBody MailLoginDO mailDO, HttpServletResponse response) throws BfstackServiceException {
        String token = userService.loginByMail(mailDO);
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(60 * 60 * 24 * 14);//保存两周
        cookie.setPath("/");
        response.addCookie(cookie);
        ResponseData<String> rd = ResponseData.getOKResult(token);
        return rd;
    }


    @CrossOrigin
    @LoginRequied
    @RequestMapping(method = RequestMethod.POST, path="logout", produces = "application/json")
    public ResponseData<Boolean> logout(HttpServletResponse response) throws Exception{
        Cookie cookie = new Cookie("token","");
        cookie.setMaxAge(0);//保存两周
        cookie.setPath("/");
        response.addCookie(cookie);
        ResponseData<Boolean> rd = ResponseData.getOKResult(userService.logout(ThreadLocalContext.getCurrentUser()));
        return rd;
    }

    @CrossOrigin
    @LoginRequied
    @RequestMapping(value = "/detail", method = {RequestMethod.POST })
    public ResponseData detail() {
        return ResponseData.getOKResult(ThreadLocalContext.getCurrentUser());
    }
}
