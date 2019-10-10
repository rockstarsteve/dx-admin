package com.dx.base.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.base.shiro.bean.User;
import com.dx.base.shiro.mapper.UserMapper;
import com.dx.base.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.base.shiro
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username).orElse(null);
    }

    @Override
    public List<String> queryUserMenuId(String username) {
        return userMapper.queryUserMenuId(username);
    }

}
