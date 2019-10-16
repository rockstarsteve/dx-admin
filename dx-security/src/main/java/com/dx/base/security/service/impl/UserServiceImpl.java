package com.dx.base.security.service.impl;

import com.dx.base.security.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Description: com.dx.base.security.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getByName(String username) {
        if (username.equals("tom")) {
            User user = new User(
                    "tom", "123456", true, true,
                    true, true, new HashSet<>());
            return user;
        } else {
            return null;
        }


    }
}
