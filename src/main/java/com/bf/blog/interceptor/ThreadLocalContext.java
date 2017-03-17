package com.bf.blog.interceptor;


import com.bf.blog.domain.User;

public class ThreadLocalContext {

	private static ThreadLocal<User> user = new ThreadLocal<User>() {
        public User initialValue() {
            return null;  
        }
    };
    
    public static User getCurrentUser(){
    	return user.get();
    }
    
    public static void setCurrentUser(User u){
    	user.set(u);
    }
    
}
