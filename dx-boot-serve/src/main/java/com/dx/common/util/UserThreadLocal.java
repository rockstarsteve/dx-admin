package com.dx.common.util;

import com.dx.sys.entity.SysUser;

/**
 * description 全局的user信息
 *
 * @author yaojian
 * @createTime 2021/12/07
 */
public class UserThreadLocal {

    /**
     * 线程变量隔离
     */
    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    private UserThreadLocal() {
    }


    public static void put(SysUser sysUser) {
        LOCAL.set(sysUser);
    }

    public static SysUser get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }

}
