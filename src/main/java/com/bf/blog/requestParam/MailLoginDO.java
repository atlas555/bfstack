package com.bf.blog.requestParam;

/**
 * Created by zhubin on 2017/1/14.
 */
public class MailLoginDO {

    private String email;
    private String password;

    public MailLoginDO(){
        super();
    }

    public MailLoginDO(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
