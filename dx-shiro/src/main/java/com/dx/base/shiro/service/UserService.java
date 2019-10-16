package com.dx.base.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dx.base.shiro.bean.User;

import java.util.List;

/**
 * Description: com.dx.base.shiro
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户菜单列表
     * @param username
     * @return
     */
    List<String> queryUserMenuId(String username);
}
