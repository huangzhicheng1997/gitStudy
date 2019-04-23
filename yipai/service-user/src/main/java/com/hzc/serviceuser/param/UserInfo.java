package com.hzc.serviceuser.param;

import com.hzc.serviceuser.entity.User;

/**
 *当前用户信息的缓存   如果被垃圾回收了拦截器验证能通过 但是当前缓冲会被清空导致系统异常   解决办法1.拦截器每次都设置一次缓冲值 2.使用单例模式(未验证)；
 */
public class UserInfo {

    private  static  ThreadLocal<User> threadLocal=new ThreadLocal<>();


    public static User getUser(){
        return threadLocal.get();
    }
    public static void setUser(User user){
        threadLocal.set(user);
    }
    public static void remove(){
        threadLocal.remove();
    }
}

/*public class UserInfo {
    private User user;

    private UserInfo(){

    }

    private  static  ThreadLocal<UserInfo> threadLocal=new ThreadLocal<>();

    public static User getUser(){
        return threadLocal.get().user;
    }
    public static void setUser(User user){
        UserInfo userInfo=new UserInfo();
        userInfo.user=user;
        threadLocal.set(userInfo);
    }
    public static void remove(){
        threadLocal.remove();
    }

}*/

