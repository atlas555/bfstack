package com.bf.blog.enums;

public enum ErrorCodeEnum {
	
	//user
	USER_NOT_LOGIN(1000, "用户未登录"),
	USER_NOT_EXISTS(1001, "账号不存在或者密码不正确"),
	VALIDATION_FAILED(1002, "验证失败"),
	USER_ALREADY_ACTIVATED(1003, "用户已激活"),
	USER_NOT_ACTIVATED(1004, "用户未激活"),
	
	//register
	GET_ARTICLE_FAILED(2001,"获取文章失败"),

	//admin
	NOT_ADMIN(9000, "没有管理员权限"),
	
	OK(0, "success"),
    UNKNOWN_ERROR(1, "服务器出了点问题，程序小哥正在努力抢修")
	;
	
	private int errorCode;
    private String errorMsg;


    ErrorCodeEnum(int errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
