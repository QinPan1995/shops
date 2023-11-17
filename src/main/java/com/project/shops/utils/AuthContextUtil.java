package com.project.shops.utils;


import com.project.shops.model.dao.SysUserDO;
import com.project.shops.model.dao.UserInfoDO;

public class AuthContextUtil {

    private static final ThreadLocal<UserInfoDO> userInfoThreadLocal = new ThreadLocal<>() ;


    // 定义存储数据的静态方法
    public static void setUserInfoDO(UserInfoDO userInfo) {
        userInfoThreadLocal.set(userInfo);
    }

    // 定义获取数据的方法
    public static UserInfoDO getUserInfoDO() {
        return userInfoThreadLocal.get() ;
    }

    // 删除数据的方法
    public static void removeUserInfoDO() {
        userInfoThreadLocal.remove();
    }


    //创建threadLocal对象
    private static final ThreadLocal<SysUserDO> threadLocal = new ThreadLocal<>();

    //添加数据
    public static void set(SysUserDO sysUser) {
        threadLocal.set(sysUser);
    }

    //获取数据
    public static SysUserDO get() {
        return threadLocal.get();
    }

    //删除数据
    public static void remove() {
        threadLocal.remove();
    }
}
