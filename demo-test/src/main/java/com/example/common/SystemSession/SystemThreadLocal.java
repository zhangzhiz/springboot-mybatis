package com.example.common.SystemSession;

import com.example.user.entity.ManageUser;

/**
 * Created by zhangzhizhong on 2017/4/26.
 */
public class SystemThreadLocal {

    private static ThreadLocal<ManageUser> local = new ThreadLocal<ManageUser>();

    public static void setUserSession(ManageUser user){
        local.set(user);
    }

    public static ManageUser getUserSession(){
        return local.get();
    }
}
