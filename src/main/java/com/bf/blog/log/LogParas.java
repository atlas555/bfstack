package com.bf.blog.log;


import com.bf.blog.utils.DateTimeUtils;

import java.util.Date;

public class LogParas {
	
	private String userId;
	private UserAction action;
    private String itemId;
    private Date time;
    private String extra;
    
    public static final String SEPARATOR = "|";
    
    public static LogParas create(String userId, UserAction action, String itemId, String extra){
    	return new LogParas(userId, action, itemId, extra);
    }
    
    public static LogParas create(String userId, UserAction action, String itemId){
    	return new LogParas(userId, action, itemId, "");
    }
    
    public static LogParas create(){
    	return new LogParas("11112222", UserAction.REGISTER_BY_MAIL, "22222", "");
    }
    
    private LogParas(String userId, UserAction action, String itemId, String extra){
        this.userId= userId;
        this.action = action;
        this.itemId = itemId;
        this.time = new Date();
        this.extra = extra;
    }
    
	public String toText() {
        StringBuffer sb = new StringBuffer("");
        sb.append(userId);
        sb.append(SEPARATOR);
        sb.append(itemId);
        sb.append(SEPARATOR);
        sb.append(DateTimeUtils.transformTime2Str(this.time));
        sb.append(SEPARATOR);
        sb.append(action);
        sb.append(SEPARATOR);
        sb.append(extra);
        sb.append(SEPARATOR);
        return sb.toString();
    }
	
	public void printToAdminLog(){
		AdminLogPrinter.getInstance().print(this.toText());
	}
	
	public void printToActionLog(){
		ActionLogPrinter.getInstance().print(this.toText());
	}
}
